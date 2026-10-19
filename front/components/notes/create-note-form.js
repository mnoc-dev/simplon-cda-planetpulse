import AppComponent from '../AppComponent.js';

export default class CreateNoteForm extends AppComponent{
    template() {
        return`
            <form>
                <p> Fields marked with <span aria-hidden="true" class="text-danger">*</span> are required</p>
                <div class="mb-3">
                    <label for="note-title" class="form-label">Title<span aria-hidden="true" class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="note-title" name="title"
                    aria-describedby="note-title-help" required maxlength="255">
                    <div id="note-title-help" class="form-text">Title must be between 1 and 255 characters</div>
                </div>
                <div class="mb-3">
                    <label for="note-date" class="form-label">Date<span aria-hidden="true" class="text-danger">*</span></label>
                    <input type="date" class="form-control" id="note-date" name="date" required>
                </div>
                <div class="mb-3">
                    <label for="note-content" class="form-label">Content<span aria-hidden="true" class="text-danger">*</span></label>
                    <textarea class="form-control" id="note-content" name="content"
                    aria-describedby="note-content-help" rows="5" required maxlength="10000"></textarea>
                    <div id="note-content-help" class="form-text">Content must be between 1 and 10,000 characters</div>
                </div>
                <button type="submit" class="btn btn-primary">Create note</button>
            </form>`
        
    }

    afterRender() {
        //TODO: add event listener to the form submit event, validate the form and send the data to the server
    }
}

customElements.define('create-note-form', CreateNoteForm);

