import AppComponent from "../AppComponent.js";

export default class ImportMessage extends AppComponent{
    beforeRender(){
        this.state = {
            text: '',
            type: 'success'
        };
    }
    
    template(){
        return `<div id="message-slot"></div>`;
    }

    show(text, type) { //change state and call updateDisplay
        this.state = {...this.state, text: text, type: type};
        this.updateDisplay();    
    }

    updateDisplay(){// update DOM
        const slot = this.querySelector('#message-slot');
        const {text, type} = this.state;

        if (!text){
            slot.innerHTML = '';
            return;
        }
        const cssClass = type === 'success' ? 'alert-success' : 'alert-danger';
        slot.innerHTML = `<div class="alert ${cssClass}">${text}</div>`;
    }
}
customElements.define('import-message', ImportMessage);