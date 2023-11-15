import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchPipe'
})
export class SearchedPipe implements PipeTransform {

  transform(value: string, input : string): string {
    if (!input) return value;
    
    const regex = new RegExp(input,"ig");
    return value.replace(regex, (match) => `<span class="highlight-text">${match}</span>`);
  }

}