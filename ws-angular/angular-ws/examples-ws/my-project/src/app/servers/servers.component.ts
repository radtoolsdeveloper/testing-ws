import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})  
export class ServersComponent implements OnInit {
  allowNewServer = false;
  serverCreationStatus = "No server created."
  serverName = 'TestServerName';
  serverCreated = false;
  servers = ['TestServer 1','TestServer 2'];

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    },2000)
   }
  
  ngOnInit() {
  }
  onServerCreation(){
    this.serverCreated = true;
    this.serverCreationStatus = "Server was created! Name is " + this.serverName;
    this.servers.push(this.serverName);
  }

  onServerNameUpdate(event : Event){
    this.serverName = (<HTMLInputElement>event.target).value;
  }
}
