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
        inputs: {
            yearMinValue: new Date().getFullYear(),
            indicatorMinValue: 0.01,
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
        <form id="add-target-form" class="needs-validation" novalidate>
            <div class="mb-3 row input-group has-validation">
                <label for="inputYear" class="col-auto col-form-label">Target year:</label>
                <div class="col-5 col-sm-3">
                    <input type="number" class="form-control" id="inputYear" min=${this.props.inputs.yearMinValue} required>
                    <div class="invalid-feedback">
                        Year is required
                    </div>
                </div>
            </div>
            
            <fieldset class="d-flex flex-column gap-md-4">
                <legend>Indicators</legend>
                 <div class="target-missing invalid-feedback mb-3">
                        At least one target must be set
                    </div>
                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputCo2" class="form-label col-md-3">CO2 emission:</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="number" class="form-control target-input" id="inputCo2" min="${this.props.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
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
                            <input type="number" class="form-control target-input" id="inputForestArea" min="${this.props.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
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
                            <input type="number" class="form-control target-input" id="inputRenewableEnergy" min="${this.props.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
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
                            <input type="number" class="form-control target-input" id="inputPM2-5" min="${this.props.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
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

    validateYear() {
        const input = document.getElementById("inputYear");
        const validityState = input.validity;

        const invalidYearFeeback = document.querySelector(
            "#inputYear + .invalid-feedback",
        );

        if (validityState.badInput) {
            invalidYearFeeback.textContent = "Year must be an integer";
        } else if (validityState.valueMissing) {
            invalidYearFeeback.textContent = "Year is required";
        } else if (validityState.rangeUnderflow) {
            invalidYearFeeback.textContent =
                "Year must be superior to " + this.props.inputs.yearMinValue;
        } else {
            input.setCustomValidity("");
        }
    }

    validateIndicatorValue(input) {
        const validityState = input.validity;

        let label = input.labels[0].textContent;
        label = label.replace(":", "");

        const invalidYearFeeback = document.querySelector(
            `#${input.getAttribute("id")} + .invalid-feedback`,
        );

        if (validityState.badInput) {
            invalidYearFeeback.textContent = label + " must be a decimal";
        } else if (validityState.valueMissing) {
            invalidYearFeeback.textContent = label + " is required";
        } else if (validityState.rangeUnderflow) {
            invalidYearFeeback.textContent =
                label +
                " must be equal to or greater than " +
                this.props.inputs.indicatorMinValue;
        } else {
            input.setCustomValidity("");
        }
    }

    validateIndicators() {
        const targets = document.querySelectorAll(".target-input");

        let hasOneTargetSetMin = false;

        let i = 0;

        for (let i = 0; i < targets.length; i++) {
            const value = targets[i].value;
            if (targets[i].validity.badInput) {
                hasOneTargetSetMin = true;
                this.validateIndicatorValue(targets[i]);
            }
        }

        const targetsMissingFeedback =
            document.querySelector(".target-missing");
        if (!hasOneTargetSetMin) {
            targetsMissingFeedback.classList.add("d-flex");
        } else {
            targetsMissingFeedback.classList.remove("d-flex");
        }
    }

    afterRender() {
        const form = document.getElementById("add-target-form");

        form.addEventListener(
            "submit",
            (event) => {
                event.preventDefault();
                event.stopPropagation();

                this.validateYear();
                this.validateIndicators();

                form.classList.add("was-validated");
            },
            false,
        );
        return;
    }
}

customElements.define("app-add-targets-form", TargetsFormComponent);
