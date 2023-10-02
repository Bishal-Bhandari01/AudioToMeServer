package com.audiotome.audiotomeserver.recommandsystem;

import com.audiotome.audiotomeserver.audiobook.AudioBook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/recommand")
@RequiredArgsConstructor
public class RecommandController {

    private final RecommandService recommService;

    @GetMapping("/content-tdidf")
    public List<AudioBook> recommandProductsByDescription(@RequestBody String description){
        return recommService.recommandAudioBookByDescription(description);
    }

}
