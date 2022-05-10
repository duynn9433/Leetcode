import { AfterViewInit, Directive, HostListener, Input, Renderer2 } from '@angular/core';
import { DomController, isPlatform } from '@ionic/angular';

@Directive({
  selector: '[appHideHeader]'
})
export class HideHeaderDirective implements AfterViewInit {
  @Input('appHideHeader') header: any;
  private headerHeight = isPlatform('ios') ? 44 : 56;
  private children: any;

  constructor(
    private rendder: Renderer2,
    private domCtrl: DomController
  ) { }

  ngAfterViewInit() {
    this.header = this.header.el;
    this.children = this.header.children;
  }

  //scroll event
  @HostListener('ionScroll', ['$event']) onContentScroll($event: any) {
    const scrollTop: number = $event.detail.scrollTop;
    let newPosition=-scrollTop;
    if(newPosition< -this.headerHeight){
      newPosition=-this.headerHeight;
    }
    let newOpacity=1-(newPosition/-this.headerHeight);

    this.domCtrl.write(() => {
      this.rendder.setStyle(this.header, 'top', newPosition +'px');
      for(let c of this.children){
        this.rendder.setStyle(c, 'opacity', newOpacity);
      }
    });
  }
}
