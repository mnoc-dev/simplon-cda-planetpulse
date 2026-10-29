import AppComponent from "../AppComponent.js"

class IndicatorsForm extends AppComponent {

      beforeRender() {

        this.state = {
            indicators : {
                        Co2EmissionUnit : "tonnes",
                        pm25Unit:"µg/m<sup>3</sup>",
                        forestAreaUnit: "%",
                        RenewableEnergyShareUnit: "%",
            },
            
            labels: {
              co2Emissions:"CO2 emissions",
              pm25: "PM2.5 Exposure",
              forestArea:"Forest area",
              RenewableEnergyShare: "Renewable energy share",

            },

            inputs: {
              yearMinValue : new Date().getFullYear(),
              indicatorMinValue : 0.01,
            },
        };

        
    }

    template(){
        return/*HTML*/`
    <h2>indicators page</h2>
    <form id="add-indicator-form" class="needs-validation" novalidate>
    <div class="mb-3 row input-group has-validation">
        <label for="inputYear" class="col-auto col-form-label">year</label>
    <div class="col-5 col-sm-3">
      <input type="number" class="form-control" id="inputYear" min=${this.state.inputs.yearMinValue + 1} required>
      <div class="invalid-feedback">
       Year is required
      </div>
    </div>
  </div>

  
            
  <div class="mb-3 md-flex align-items-center gap-3">
  <label for ="inputCo2" class="form-label" col-md-3><span>${this.state.labels.co2Emissions}(${this.state.indicators.Co2EmissionUnit}:</span> Co2 emission/tonnes</label>
  <input type="number" class="form-control" id="co2Emission">
  </div>

          <div class="">
    <label for"renewableEnergyShare" class="">Renewable Energy Share/percent</label>
    <input type="number" class="form-control" id="renewableEnergyShare">
  </div>

          <div class="">
    <label for"forestArea" class="">Forest area/percent</label>
    <input type="number" class="form-control" id="forestArea">
  </div>

      <div class="">
    <label for"pm25Exposure" class="">PM25 exposure/µg/m<sup>3</sup></label>
    <input type="number" class="form-control" id="pm25Exposure">
  </div>
    
    </div>
    

</form>

       
         `     
    }

    afterRender() {
        this.#handleIndicators();
    }

    #handleIndicators() {
        const parent = this.querySelector('#form');
        this.attachChildren(parent, 'indicator-item');
    }


}

customElements.define("indicators-form", IndicatorsForm)
  

