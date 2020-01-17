import { Directive, ElementRef, Renderer2, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appColor]'
})
export class ColorDirective {

  constructor(private el: ElementRef, private renderer: Renderer2) {
    // this.el.nativeElement.style.background = 'red';
    // this.el.nativeElement.style.fontSize = '30px';

    // const h1 = this.renderer.createElement('h1');
    // const text = this.renderer.createText('Hello from custom directive');
    // this.renderer.appendChild(h1, text);
    // this.renderer.appendChild(this.el.nativeElement, h1);
  }

  @HostBinding('style.background') backgroundColor: string;

  @HostListener('mouseenter')
  x() {
    //this.el.nativeElement.style.background = '#ccc';

    this.backgroundColor = 'blue';
    this.el.nativeElement.style.color = 'red';
    this.el.nativeElement.style.fontSize = '25px';
  }

  @HostListener('mouseleave')
  y() {
    this.el.nativeElement.style.background = 'lightblue';
    this.el.nativeElement.style.color = 'black';
    this.el.nativeElement.style.fontSize = '15px';
  }

}
