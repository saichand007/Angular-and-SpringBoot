import { TestBed, inject } from '@angular/core/testing';

import { TopicserviceService } from './topicservice.service';

describe('TopicserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TopicserviceService]
    });
  });

  it('should be created', inject([TopicserviceService], (service: TopicserviceService) => {
    expect(service).toBeTruthy();
  }));
});
