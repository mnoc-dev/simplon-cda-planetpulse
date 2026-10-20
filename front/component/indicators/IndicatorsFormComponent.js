import AppComponent from "../../component/AppComponent.js"

class IndicatorsFormComponent extends AppComponent {

      beforeRender() {

        this.state = {
            indicators : ["year","co2_emission", "PM2.5 exposure", "Forest area", "renewable energy share"]
        };

        
    }

    template(){
        return/*HTML*/`
         <h2>indicators page</h2>

         <form id="form">
         <label id="label">
         <input type = "number" id ="type">
         
         </label>  
         </form>
         `
    /* <form action="" method="get" class="form-example" id ="form">
  <div class="form-indicator">
    <label id="fields">year </label>
    <input type="text" name="year" id="year" required />
  </div>
  <div class="form-example">
    <label for="email">Enter your email: </label>
    <input type="email" name="email" id="email" required />
  </div>
  <div class="form-example">
    <input type="submit" value="Subscribe!" />
  </div>
</form>*/
            
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
  

