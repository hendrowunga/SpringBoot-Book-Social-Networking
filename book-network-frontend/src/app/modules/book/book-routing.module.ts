import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import {authGuard} from '../../services/guard/auth.guard';
import { MainComponent } from './pages/main/main.component';
import {BookListComponent} from './pages/book-list/book-list.component';
import {MyBooksComponent} from './pages/my-books/my-books.component';

const routes: Routes = [
  {
      path: '',
      component: MainComponent,
//       canActivate: [authGuard],
      children:[
        {
          path: '',
          component: BookListComponent
          },
        {
                path: 'my-books',
                component: MyBooksComponent
//                 canActivate: [authGuard]
              }
        ]
  }

  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
