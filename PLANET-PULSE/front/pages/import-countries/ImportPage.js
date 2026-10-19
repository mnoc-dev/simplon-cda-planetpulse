import AppComponent from "../../components/AppComponent.js";
import ImportButton from "../../components/import-countries/ImportButton.js"; 
import ImportMessage from "../../components/import-countries/ImportMessage.js";

export default class ImportPage extends AppComponent{
    template(){
        return `<h1>IMPORT COUNTRIES</h1>
        <p>description of the import
        </p>
        <import-button></import-button>
        <import-message></import-message>
        `;
    }
    afterRender(){
        const button = this.querySelector('import-button');
        const message = this.querySelector('import-message')

        button.addEventListener('import-success',(e) => {
            const count = e.detail.count;
            message.show(`${count} imported countries`, 'success')
        });

        button.addEventListener('import-error', (e) => {
            const message = e.detail.message;
            message(`Erreur : ${message}`, `error`);
        });    
    }


}
customElements.define('import-page', ImportPage);