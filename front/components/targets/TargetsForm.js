import AppComponent from "../AppComponent.js";
import "../buttons/FormButton.js";

export default class TargetsFormComponent extends AppComponent {
    beforeRender() {
        this.state = {
            targets: {
                co2EmissionsUnit: "tonnes",
                forestAreaUnit: "%",
                RenewableEnergyShareUnit: "%",
                pm25Unit: "µg/m<sup>3</sup>",
            },
            labels: {
                co2Emissions: "CO2 emissions",
                forestArea: "Forest area",
                RenewableEnergyShare: "Renewable energy share",
                pm25: "PM2.5 Exposure",
            },
            inputs: {
                yearMinValue: new Date().getFullYear(),
                indicatorMinValue: 0.01,
            },
        };
    }

    template() {
        return `  
        <form id="add-target-form" class="needs-validation" novalidate>
            <div class="mb-3 row input-group has-validation">
                <label for="inputYear" class="col-auto col-form-label">Target year:</label>
                <div class="col-5 col-sm-3">
                    <input type="number" class="form-control" id="inputYear" min=${this.state.inputs.yearMinValue + 1} required>
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
                    <label for="inputCo2" class="form-label col-md-3"><span>${this.state.labels.co2Emissions}</span> (${this.state.targets.co2EmissionsUnit}):</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="number" class="form-control target-input" id="inputCo2" min="${this.state.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
                        </div>
                    </div>
                </div>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputForestArea" class="form-label col-md-3"><span>${this.state.labels.forestArea}</span> (${this.state.targets.forestAreaUnit}):</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="number" class="form-control target-input" id="inputForestArea" min="${this.state.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
                            </div>
                    </div>
                </div>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputRenewableEnergy" class="form-label col-md-3"><span>${this.state.labels.RenewableEnergyShare}</span> (${this.state.targets.RenewableEnergyShareUnit}):</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="number" class="form-control target-input" id="inputRenewableEnergy" min="${this.state.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
                        </div>
                    </div>
                </div>

                <div class="mb-3 d-md-flex align-items-center gap-3">
                    <label for="inputPM2-5" class="form-label col-md-3"><span>${this.state.labels.pm25}</span> (${this.state.targets.pm25Unit}):</label>
                    <div class="row flex-grow-1">
                        <div class="col">
                            <input type="number" class="form-control target-input" id="inputPM2-5" min="${this.state.inputs.indicatorMinValue}" step="any">
                            <div class="invalid-feedback">
                                Please enter valid value
                            </div>
                        </div>
                    </div>
                </div>
            </fieldset>
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
                "Year must be superior to " + this.state.inputs.yearMinValue;
        } else {
            input.setCustomValidity("");
        }
    }

    validateIndicatorValue(input) {
        const validityState = input.validity;

        const label = input.labels[0].firstChild.textContent;

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
                this.state.inputs.indicatorMinValue;
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
            if (targets[i].value.length > 0 || targets[i].validity.badInput) {
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

        this.attachChild(form, "app-form-button", { action: "Créer" });

        const styleSheet = new CSSStyleSheet();

        styleSheet.replaceSync(`
            .form-control.is-valid,
            .was-validated .form-control:valid {
                background-image: none;
                border-color: #dee2e6;
            }

            main {
                padding: 1rem;
            }

            /* Small devices (landscape phones, 576px and up) */
            @media (min-width: 576px) {
                main {
                    padding: 5%;
                }
            }

            /* Medium devices (tablets, 768px and up) */
            @media (min-width: 768px) {
                main {
                    padding-left: 10%;
                    padding-right: 10%;
                }
            }

            /* Large devices (desktops, 992px and up) */
            @media (min-width: 992px) {
                main {
                    padding-left: 15%;
                    padding-right: 15%;
                }
            }
        `);

        document.adoptedStyleSheets.push(styleSheet);

        return;
    }
}

customElements.define("app-add-targets-form", TargetsFormComponent);
