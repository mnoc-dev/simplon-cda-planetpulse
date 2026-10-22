import AppComponent from '../AppComponent.js';

const ISO_COUNTRY_CODE= /^[A-Z]{2}$/; // ISO 3166-1 alpha-2 country code format

export default class CreateNoteForm extends AppComponent{

    beforeRender() {
        const params = new URLSearchParams(window.location.search);
        const countryCode = params.get('country');
        if (countryCode && ISO_COUNTRY_CODE.test(countryCode)) {
            this.state = { countryCode };
        } else {
            this.state = { countryCode: null };
        }   
    }

    template() {
        if (this.state.countryCode === null) {
            return `<p class="text-danger">Invalid country code in URL</p>`;
        }
        return`
            <form id="note-form" novalidate>
                <p> Fields marked with <span aria-hidden="true" class="text-danger">*</span> are required</p>
                <div class="mb-3">
                    <label for="note-title" class="form-label">Title<span aria-hidden="true" class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="note-title" name="title"
                    aria-describedby="note-title-help note-title-invalid-feedback" required maxlength="255">
                    <div class="invalid-feedback" id="note-title-invalid-feedback">
                    Please enter a title between 1 and 255 characters.
                    </div>    
                    <div id="note-title-help" class="form-text">Title must be between 1 and 255 characters</div>
                </div>
                <div class="mb-3">
                    <label for="note-date" class="form-label">Date<span aria-hidden="true" class="text-danger">*</span></label>
                    <input type="date" class="form-control" id="note-date" name="date" aria-describedby="note-date-invalid-feedback" required>
                    <div class="invalid-feedback" id="note-date-invalid-feedback">
                    Please choose a date.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="note-content" class="form-label">Content<span aria-hidden="true" class="text-danger">*</span></label>
                    <textarea class="form-control" id="note-content" name="content"
                    aria-describedby="note-content-help note-content-invalid-feedback" rows="5" required maxlength="10000"></textarea>
                    <div class="invalid-feedback" id="note-content-invalid-feedback">
                    Please enter content between 1 and 10,000 characters.
                    </div>
                    <div id="note-content-help" class="form-text">Content must be between 1 and 10,000 characters</div>
                </div>
                <button type="submit" class="btn btn-primary">Create note</button>
            </form>`
        
    }

    #todayAsIsoDate() {
        const today = new Date();
        const year = today.getFullYear();
        const month = String(today.getMonth() + 1).padStart(2, '0'); // Months are zero-based
        const day = String(today.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }
    afterRender() {

        if (this.state.countryCode === null) {
            return; // Don't add event listener if country code is invalid
        }

        this.querySelector('#note-date').value = this.#todayAsIsoDate();

        const form = this.querySelector('#note-form');
        form.addEventListener('submit',(event) => {
            this.#handleFormSubmit(event);        
    });
    }

    #handleFormSubmit(event) {
        const form = event.currentTarget;
        event.preventDefault(); // Prevent the default form submission

        form.classList.add('was-validated');
        if (!form.checkValidity()) {
            
            return; // Stop if the form is invalid
        }      
        console.log('Form is valid');
}
}
customElements.define('create-note-form', CreateNoteForm);