import AppComponent from "../../component/AppComponent.js"

class IndicatorsFormComponent extends AppComponent {

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
    <form>
    <div class="mb-3>
    <div class="">
    <label for="inputYear" class="">year</label>
    <input type="number" class="form-control" id="inputYear" required>
  </div>

  <div class="">
  <label for "co2Emission" class=""> Co2 emission/tonnes</label>
  <input type="number" class="form-control" id="co2Emission">
  </div>

          <div class="">
    <label for"renewableEnergyShare" class="">Renewable Energy Share/percent</label>
    <input type="number" class="form-control" id="RenewableEnergyShare">
  </div>

          <div class="">
    <label for"forestArea" class="">Forest area/percent</label>
    <input type="number" class="form-control" id="forestArea">
  </div>

      <div class="">
    <label for"pm25" class="">PM25 exposure/µg/m<sup>3</sup></label>
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

customElements.define("indicators-form", IndicatorsFormComponent)
  

