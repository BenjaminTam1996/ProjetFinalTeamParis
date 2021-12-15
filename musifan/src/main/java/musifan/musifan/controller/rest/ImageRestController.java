package musifan.musifan.controller.rest;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.Artiste;
import musifan.musifan.services.ArtisteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/image")
public class ImageRestController {
	@Autowired
	private ArtisteService artisteService;
	
	@PostMapping(value="/artiste/profil/{id}",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	//@JsonView(JsonViews.Common.class)
	public void updatephoto(@RequestParam("image") MultipartFile multiPartFile,@PathVariable("id")Long id) {
		Artiste  artiste =musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byId(id));
		try {
			artiste.setPhotoProfil(multiPartFile.getBytes());
			System.out.println(artiste.getPhotoProfil()); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(artiste),id);
		
	}

}

