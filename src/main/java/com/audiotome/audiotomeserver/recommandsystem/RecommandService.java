package com.audiotome.audiotomeserver.recommandsystem;

import com.audiotome.audiotomeserver.audiobook.AudioBook;
import com.audiotome.audiotomeserver.audiobook.AudioBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommandService {

    private final AudioBookRepository auRepo;

    public List<AudioBook> recommandAudioBookByDescription(String desc) {

        List<AudioBook> allProducts = (List<AudioBook>) auRepo.findAll();
        List<String> tokenedQuery = Arrays.asList(desc.toLowerCase().split("\\s+"));

        Map<AudioBook, Double> productSimilarities = new HashMap<>();
        for(AudioBook audio: allProducts){
            List<String> tokenizedDesc = Arrays.asList(audio.getADescription().toLowerCase().split("\\s+"));
            long termFrequency = tokenizedDesc.stream()
                    .filter(tokenedQuery::contains)
                    .count();
            long documentFrequency = allProducts.stream()
                    .filter(p -> p.getADescription().toLowerCase().contains(tokenedQuery.get(0)))
                    .count();
            double tfidfScore = (termFrequency/(double) tokenizedDesc.size())*
                    Math.log(allProducts.size()/(double) (documentFrequency + 1));

            productSimilarities.put(audio, tfidfScore);
        }

        List<AudioBook> recommandProducts = productSimilarities.entrySet()
                .stream()
                .sorted(Map.Entry.<AudioBook, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return recommandProducts;
    }

}
