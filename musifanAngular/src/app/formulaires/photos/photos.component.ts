import { Component, OnInit } from "@angular/core";
import { HttpClient, HttpEventType, HttpHeaders } from "@angular/common/http";

@Component({
  selector: "app-photos",
  templateUrl: "./photos.component.html",
  styleUrls: ["./photos.component.css"],
})
export class PhotosComponent implements OnInit {
  constructor(private httpClient: HttpClient) {}

  selectedFile: any;
  message: string = "";
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;

  ngOnInit(): void {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: "Basic " + sessionStorage.getItem("token"),
    });
  }

  //Gets called when the user selects an image
  public onFileChanged(event) {
    //Select File

    this.selectedFile = event.target.files[0];
  }
  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.selectedFile);

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append("image", this.selectedFile, this.selectedFile.name);

    //Make a call to the Spring Boot Application to save the image
    this.httpClient
      .post(
        "http://localhost:8080/musifan/api/image/artiste/profil/" +
          sessionStorage.getItem("id"),
        uploadImageData,
        {
          headers: this.httpHeaders,
          observe: "response",
        }
      )
      .subscribe((response) => {
        if (response.status === 200) {
          this.message = "Image uploaded successfully";
        } else {
          this.message = "Image not uploaded successfully";
        }
      });
  }
}
