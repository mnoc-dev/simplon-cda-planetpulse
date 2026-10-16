import AppComponent from "../../../lib/AppComponent.js";

export default class ImportButton extends AppComponent{
    beforeRender(){
        this.state = {
            status: 'idle'
        };
    }
    template() {
        return `
        <button type="button" class="theme-success btn-solid btn-styled rounded-pill">
        IMPORT COUNTRIES
        </button>
        `;
    }
    afterRender(){
        const button = this.querySelector('button'); 
        //querySelector recherche la premiere occurence dans ce scope du mot entre parenthèse

        if (button) {
            button.addEventListener('click', () => {
                // si il y a l'event click sur le bouton fais ce qui suit(ici arrow anonymous function)
                this.handleClick();
            });
        }
    }

    handleClick(){
        if(this.state.status === 'loading' || this.state.status === 'success'){
            return;// security
        }
        this.state = { ...this.state, status: 'loading'};

        this.updateButtonDisplay();

        this.runImport();
        }
    
    updateButtonDisplay(){
        const button = this.querySelector('button');
        const status = this.state.status;

        if (status === 'loading') {
            button.disabled = true;
            button.textContent = 'Import in process...';
        }else if (status === 'success') {
            button.disabled = true;
            button.textContent = 'Imported.';
        }else{
            button.disabled = false;
            button.textContent = 'Click here to import countries';
        }
    }
    runImport(){//simulation of loading import
        setTimeout(() => {
            this.onImportSuccess(195);
        }, 2000);
    }
    onImportSuccess(count){
        this.state = {...this.state, status : 'success'}; 
        this.updateButtonDisplay();
        this.dispatchEvent(new CustomEvent('import-success', {
            detail: { count : count }
        }));
    }
    onImportError(message){
        this.state = {...this.state, status : 'error'};
        this.updateButtonDisplay();
        this.dispatchEvent(new CustomEvent('import-error', {detail: { message : message }
        }));
    }
}

customElements.define('import-button', ImportButton);
