import AppComponent from "../AppComponent.js";

class AppHeader extends AppComponent {
    template() {
        return /* html */`
        <header>
            <nav class="navbar navbar-expand-lg px-3 px-md-4 py-3" aria-label="Main navigation">
                <div class="container-fluid">
                    <a class="navbar-brand d-flex align-items-center gap-2" href="/country-list.html" aria-label="PlanetPulse - Home">
                        <img class="logo-icon" src="/front/assets/images/planet.png" alt="logo PlanetPulse">
                        <img class="logo-name" src="/front/assets/images/planetpulse.png" alt="PlanetPulse">
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#app-header-navigation" aria-controls="app-header-navigation"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="app-header-navigation">
                        <ul class="navbar-nav ms-auto gap-lg-3">
                            <li class="nav-item"><a class="nav-link" href="/country-list.html">Country list</a></li>
                            <li class="nav-item"><a class="nav-link" href="#indicators">Indicators</a></li>
                            <li class="nav-item"><a class="nav-link" href="#targets">Targets</a></li>
                            <li class="nav-item"><a class="nav-link" href="#notes">Notes</a></li>
                            <li class="nav-item"><a class="nav-link" href="#report">Report</a></li>
                        </ul>
                    </div>
                </div> 
            </nav> 
        </header>
        `;
    }
}

customElements.define('app-header', AppHeader);
