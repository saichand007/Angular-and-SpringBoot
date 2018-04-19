import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {RequestOptions, Http,Headers} from "@angular/http";
import {Topic} from"./model";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TopicService {
  newdata:string;
  data:{};

  constructor(private http:Http) { }
  getData() {

    return this.http.get('http://localhost:8080/rest/topics');
  
  }
  postData(value:any) {
    this.newdata=JSON.stringify(value);
    console.log(typeof(value));
    console.log(this.newdata);
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
 
    return this.http.post('http://localhost:8080/rest/savetopics',value,options);
  
  }
  getTopic(id:any) {

    return this.http.get('http://localhost:8080/rest/topics/'+id);
  
  }

  updateTopic(id:any)
  {
    let body;
    return this.http.put('http://localhost:8080/rest/updatetopics/'+id,body);
  }

  deleteTopic(id:any)
  {
    return this.http.delete('http://localhost:8080/rest/deletetopics/'+id);
  }
  
  course(value:any)
  {
   this.data=value;
   console.log(this.data);
  }
  
}
