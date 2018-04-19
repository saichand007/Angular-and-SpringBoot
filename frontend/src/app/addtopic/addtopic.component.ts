import { Component, OnInit } from '@angular/core';
import {Topic} from "../model";
import { TopicService } from '../topicservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addtopic',
  templateUrl: './addtopic.html',
  styleUrls: ['./addtopic.component.css']
})
export class AddtopicComponent implements OnInit {

  topic:Topic=new Topic();
  self:boolean;

  constructor(private service:TopicService,private router:Router) { }

  submit(value:any)
  {
    this.service.postData(value)     
    .subscribe(
      res => {
        if(res)
        {
          console.log(res);

          this.router.navigate(['/topics']);
          this.reset();
        }
     
      },
      err => {
        console.log("Error occured");
      }
    );
     console.log(value);
  }

  ngOnInit()
   {
     if(this.service.data !=null)
     {
   this.topic=Object.assign(this.service.data)

     }

     if(this.topic.id !="" && this.topic.id !="undefined")
     {
       this.self=true;
     }
  }

  delete(value:any)
  {
    console.log(value);
    this.service.deleteTopic(value)
    .subscribe(res=>
      {
        this.router.navigate(['/topics']);  
      this.reset();
       },
      err=>{console.log(err)});
  }

  reset()
  {
    this.topic.id="";
    this.topic.name="";
    this.topic.description="";
  }

}
