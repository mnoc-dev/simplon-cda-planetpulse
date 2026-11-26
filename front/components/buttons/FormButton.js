import AppComponent from "../AppComponent.js";

class FormButtonComponent extends AppComponent {
  template() {
    return `
    <div class= "mb-3 form-submit">

    <button type="submit" class="btn btn-primary">${this.props.action}</button>


    </div>

    `;
  }

  afterRender() {
    const button = this.querySelector("button");
    button.addEventListener("click", () => {
      /*button.disabled = true;*/
    });
  }
}

customElements.define("app-form-button", FormButtonComponent);
