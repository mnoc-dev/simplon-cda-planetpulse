import AppComponent from "../AppComponent.js";

export default class FormButtonComponent extends AppComponent {
    template() {
        return `<div class="d-flex justify-content-end mt-4">
        <button type="submit" class="btn btn-pp">${this.props.action}</button>
        </div>
        `;
    }

    afterRender() {
        const styleSheet = new CSSStyleSheet();

        styleSheet.replaceSync(
            `
                    .btn-pp {
                        background-color: var(--green-pp);
                        color: var(--white-pp);
                    }
        
                    .btn-pp:hover {
                        cursor: pointer;
                    }
                    `,
        );

        document.adoptedStyleSheets.push(styleSheet);
    }
}

customElements.define("app-form-button", FormButtonComponent);
