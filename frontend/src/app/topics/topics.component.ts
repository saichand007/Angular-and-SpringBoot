import { Component, OnInit } from '@angular/core';
import { TopicService } from '../topicservice.service';
import {Topic} from "../model";
import { Router } from '@angular/router';


@Component({
  selector: 'app-topics',
  templateUrl: './topics.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit {
  resdata:{};

  constructor(private service:TopicService,private router:Router) { 

    this.service.getData()
     .subscribe(res=>{
       console.log(res);
      this.logdata(res);},err=>{console.log("error occured")});
     
  }

  logdata(res:any)
  {
    this.resdata=JSON.parse(res._body);
    console.log(this.resdata);
  }

  delete(value:any)
  {
    console.log(value.id);
    this.service.deleteTopic(value.id)
    .subscribe(res=>
      {this.router.navigate(['/topics'])},
      err=>{console.log(err)});
  }

  update(value:any)
  {
     this.service.course(value);
     this.router.navigate(['/addtopic'])
  }

  ngOnInit() {
  }

}
