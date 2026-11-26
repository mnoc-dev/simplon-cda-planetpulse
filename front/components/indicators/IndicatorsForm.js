import AppComponent from "../AppComponent.js";
import "../buttons/FormButton.js";

class IndicatorsForm extends AppComponent {
  beforeRender() {
    this.state = {
      indicators: {
        Co2EmissionUnit: "tonnes",
        pm25Unit: "µg/m<sup>3</sup>",
        forestAreaUnit: "%",
        RenewableEnergyShareUnit: "%",
      },

      labels: {
        co2Emissions: "CO2 emissions",
        pm25: "PM2.5 Exposure",
        forestArea: "Forest area",
        RenewableEnergyShare: "Renewable energy share",
      },

      inputs: {
        yearMaxValue: new Date().getFullYear(),
        indicatorMinValue: 0.01,
      },
    };
  }

  template() {
    return /*HTML*/ `
    <h2>indicators page</h2>


    <form id="add-indicator-form" class="needs-validation" novalidate was-validated>
    <div class="mb-3 row input-group has-validation">
        <label for="inputYear" class="col-auto col-form-label">indicator year</label>
    <div class="col-5 col-sm-3">
      <input type="number" class="form-control" id="inputYear" max=${this.state.inputs.yearMaxValue} required>
      <div class="invalid-feedback">
       Year is required
      </div>
    </div>
  </div>

  
   <fieldset class="d-flex flex-column gap-md-4">
                <legend>Indicators</legend>
               <div class="indicator-missing invalid-feedback mb-3">
  At least one indicator must be set
</div>
  <div class="mb-3 md-flex align-items-center gap-3">
  <label for ="inputCo2" class="form-label" col-md-3><span>${this.state.labels.co2Emissions}(${this.state.indicators.Co2EmissionUnit}:</span> Co2 emission/tonnes</label>
  <input type="number" class="form-control" id="co2Emission" min=${this.state.inputs.indicatorMinValue} step="0.01">
  </div>

          <div class="">
    <label for"renewableEnergyShare" class="form-label" col-md-3>Renewable Energy Share/percent</label>
    <input type="number" class="form-control" id="renewableEnergyShare" min=${this.state.inputs.indicatorMinValue} step="0.01">
  </div>

          <div class="">
    <label for"forestArea" class="form-label" col-md-3>Forest area/percent</label>
    <input type="number" class="form-control" id="forestArea" min=${this.state.inputs.indicatorMinValue} step="0.01">
  </div>

      <div class="">
    <label for"pm25Exposure" class="">PM25 exposure/µg/m<sup>3</sup></label>
    <input type="number" class="form-control" id="pm25Exposure" min=${this.state.inputs.indicatorMinValue} step="0.01">
  </div>
    
</fieldset>
</form>     
         `;
  }

  validateIndicators() {
    const indicators = [
      document.getElementById("co2Emission"),
      document.getElementById("renewableEnergyShare"),
      document.getElementById("forestArea"),
      document.getElementById("pm25Exposure"),
    ];

    const indicatorMissingFeedback = this.querySelector(".indicator-missing");
    const hasValue = indicators.some((input) => input.value !== "");
    const allValid = indicators.every((input) => input.checkValidity());

    if (!hasValue) {
      indicatorMissingFeedback.style.display = "block";
    } else {
      indicatorMissingFeedback.style.display = "none";
    }

    if (!allValid) {
      indicators.forEach((input) => input.reportValidity());
      return false;
    }

    return true;
  }

  validateYear() {
    const input = document.getElementById("inputYear");
    const validityState = input.validity;
    const invalidYearFeeback = document.querySelector(
      "#inputYear + .invalid-feedback",
    );

    if (validityState.badInput || validityState.stepMismatch) {
      invalidYearFeeback.textContent = "year must be an integer";
    } else if (validityState.valueMissing) {
      invalidYearFeeback.textContent = "Year is required";
    } else if (validityState.rangeOverflow) {
      invalidYearFeeback.textContent =
        "Year must be " + this.state.inputs.yearMaxValue + " or earlier";
    } else {
      input.setCustomValidity("");
    }
    return input.checkValidity();
  }

  afterRender() {
    this.#handleIndicators();

    const form = document.getElementById("add-indicator-form");

    form.addEventListener(
      "submit",
      (event) => {
        event.preventDefault();
        event.stopPropagation();

        this.validateYear();
        const indicatorsValid = this.validateIndicators();
        form.classList.add("was-validated");

        if (!indicatorsValid) {
          return;
        }

        // form is valid, can submit data here
        console.log("form submitted successfuly");
      },
      false,
    );
    this.attachChild(form, "app-form-button", { action: "create" });
  }

  #handleIndicators() {
    const parent = this.querySelector("#add-indicator-form");
    this.attachChildren(parent, "indicator-item");
  }
}

customElements.define("indicators-form", IndicatorsForm);
