import AppComponent from "../../AppComponent.js";

import styles from "./targets-form.css" with { type: "css" };

export default class TargetsFormComponent extends AppComponent {
    #props = {
        targets: {
            co2EmissionsUnit: "tonnes",
            forestAreaUnit: "%",
            RenewableEnergyShareUnit: "%",
            pm25Unit: "µg/m<sup>3</sup>",
        },
    };

    connectedCallback() {
        this.beforeRender();
        this.#render();
        this.afterRender();
    }

    get props() {
        return this.#props;
    }

    #render() {
        this.innerHTML = this.template();
        document.adoptedStyleSheets.push(styles);
    }

    template() {
        return `  
        <form class="needs-validation">
            <div class="mb-3 row">
                <label for="inputYear" class="col-auto col-form-label">Target year:</label>
                <div class="col-5 col-sm-3">
                    <input type="text" class="form-control" id="inputYear">
                </div>
            </div>
            
            <fieldset class="d-flex flex-column gap-md-4">
                <legend>Indicators</legend>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputCo2" class="form-label col-md-3">CO2 emission:</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="text" class="form-control" id="inputCo2" />
                        </div>
                        <div class="col-3 col-sm-2 my-auto">
                            <span>${this.props.targets.co2EmissionsUnit}</span>
                        </div>
                    </div>
                </div>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputForestArea" class="form-label col-md-3">Forest area:</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="text" class="form-control" id="inputForestArea">
                        </div>
                        <div class="col-3 col-sm-2 my-auto">
                            <span>${this.props.targets.forestAreaUnit}</span>
                        </div>
                    </div>
                </div>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputRenewableEnergy" class="form-label col-md-3">Renewable energy share:</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="text" class="form-control" id="inputRenewableEnergy">
                        </div>
                        <div class="col-3 col-sm-2 my-auto">
                            <span>${this.props.targets.RenewableEnergyShareUnit}</span>
                        </div>
                    </div>
                </div>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputPM2-5" class="form-label col-md-3">PM2.5 exposure:</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="text" class="form-control" id="inputPM2-5">
                        </div>
                        <div class="col-3 col-sm-2 my-auto">
                            <span>${this.props.targets.pm25Unit}</span>
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="d-flex justify-content-end mt-4">
                <button type="submit" class="btn btn-pp">Create</button>
            </div>
        </form>
        `;
    }
}

customElements.define("app-add-targets-form", TargetsFormComponent);
