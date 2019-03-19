import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styles: [`
    .online{
      color: white;
    }
  `]
})
export class ServerComponent implements OnInit {
  serverStatus = 'offline';
  serverId = 10;
  
  constructor() {
    this.serverStatus = Math.random() > 0.5 ? 'online':'offline';
  }

  ngOnInit() {
  }

  getServerStatus() {
    return this.serverStatus;
  }

  getColor(){
    if(this.serverStatus=='online'){
      return 'green';
    }
    return 'red';
  }
}
