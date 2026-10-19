import AppComponent from "../../components/AppComponent.js";
import ImportButton from "../../components/import-countries/ImportButton.js"; 

export default class ImportPage extends AppComponent{
    template(){
        return `<h1>IMPORT COUNTRIES</h1>
        <p>description of the import
        </p>
        <div id="message-container">
        </div>

        <import-button></import-button>
        `;
    }
    afterRender(){
        const button = this.querySelector('import-button');

        button.addEventListener('import-success',(e) => {
            const count = e.detail.count;
            this.showMessage(`${count} imported countries`, 'success')
        });

        button.addEventListener('import-error', (e) => {
            const message = e.detail.message;
            this.showMessage(`Erreur : ${message}`, `error`);
        });    
    }

}
customElements.define('import-page', ImportPage);