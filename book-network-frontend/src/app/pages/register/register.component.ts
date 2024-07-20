import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {RegistrationRequest} from '../../services/models/registration-request';
import {AuthenticationService} from '../../services/services/authentication.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerRequest: RegistrationRequest ={email:'',firstname:'',lastname:'',password:''};
  errorMsg: Array<string> = [];

constructor(
  private router: Router,
  private authService: AuthenticationService

  ){}

  login(){
  this.router.navigate(['login']);
    }

  register(){

    }
}
