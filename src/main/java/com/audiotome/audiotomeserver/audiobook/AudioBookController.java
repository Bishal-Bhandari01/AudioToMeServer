package com.audiotome.audiotomeserver.audiobook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
>>>>>>> 17faaac ( new server hosting)

@RestController
@RequestMapping("api/v1/audiobook")
@CrossOrigin
public class AudioBookController {

    @Autowired
    public AudioBookService audioBookService;
<<<<<<< HEAD

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public AudioBookListResponseDto GetAllAudioBook(){
=======
    private FileUploadService fileUploadService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public AudioBookListResponseDto GetAllAudioBook() {
>>>>>>> 17faaac ( new server hosting)
        return audioBookService.getAllAudioBook();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
<<<<<<< HEAD
    public AudioBookResponseDto SaveAudioBook(@RequestBody AudioBookCreateDto request){
=======
    public AudioBookResponseDto SaveAudioBook(@RequestBody AudioBookCreateDto request) {
>>>>>>> 17faaac ( new server hosting)
        return audioBookService.saveAudioBook(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
<<<<<<< HEAD
    public AudioBookResponseDto UpdateAudioBook(@PathVariable Long aId, @RequestBody AudioBookUpdateDto request){
        return audioBookService.updateAudioBook(aId,request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AudioBookResponseDto GetAudioBookById(@PathVariable Long aId){
=======
    public AudioBookResponseDto UpdateAudioBook(@PathVariable Long aId, @RequestBody AudioBookUpdateDto request) {
        return audioBookService.updateAudioBook(aId, request);
    }

    @RequestMapping(value = "/getByAId", method = RequestMethod.GET)
    public AudioBookResponseDto GetAudioBookById(@RequestParam("aId") Long aId) {
>>>>>>> 17faaac ( new server hosting)
        return audioBookService.getAudioBookById(aId);
    }

    @RequestMapping(path = "/getDataByStatus/{status}", method = RequestMethod.GET)
<<<<<<< HEAD
    public AudioBookListResponseDto GetAudioBookByStatus(@PathVariable("status") Status status){
        return audioBookService.getAudioBooksByStatus(status);
    }

    @RequestMapping(value = "/deleteByid/{id}",method = RequestMethod.DELETE)
    public void DeleteById(@PathVariable("id") Long id){
        audioBookService.deleteById(id);
    }

    @RequestMapping(value = "/SearchByName/{title}",method = RequestMethod.GET)
    public AudioBookListResponseDto GetAudioBookByTitle(@PathVariable("title") String title){
        return audioBookService.getaudioBookByTitle(title);
    }

//    @RequestMapping(value = "/addAudioBookSound",method = RequestMethod.POST)
//    public
=======
    public AudioBookListResponseDto GetAudioBookByStatus(@PathVariable("status") Status status) {
        return audioBookService.getAudioBooksByStatus(status);
    }

    @RequestMapping(value = "/deleteByid/{id}", method = RequestMethod.DELETE)
    public void DeleteById(@PathVariable("id") Long id) {
        audioBookService.deleteById(id);
    }

    @RequestMapping(value = "/SearchByName/{title}", method = RequestMethod.GET)
    public AudioBookListResponseDto GetAudioBookByTitle(@PathVariable("title") String title) {
        return audioBookService.getaudioBookByTitle(title);
    }

    @RequestMapping(value = "/postAudioBook", method = RequestMethod.POST)
    public String FileUpload(@RequestPart("file") MultipartFile file) throws IOException {

        return fileUploadService.uploadFile(file);
    }
>>>>>>> 17faaac ( new server hosting)

}
