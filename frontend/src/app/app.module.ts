import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import{HttpModule} from '@angular/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AddtopicComponent } from './addtopic/addtopic.component';
import { TopicsComponent } from './topics/topics.component';
import { TopicService } from './topicservice.service';

const routes: Routes = [
  { path: '',redirectTo: '/topics',pathMatch: 'full'},
  { path: 'topics', component: TopicsComponent },
  { path: 'addtopic', component: AddtopicComponent },

];

@NgModule({
  declarations: [
    AppComponent,
    AddtopicComponent,
    TopicsComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,HttpModule,FormsModule,RouterModule.forRoot(routes)
  ],
  providers: [TopicService],
  bootstrap: [AppComponent]
})
export class AppModule { }
