// Temporary display data. Replace this source when the backend import is ready.
// code uses ISO 3166-1 alpha-2 (two letters).
// CountryCard expects { name, code, region, flag }; map backend fields here.
export const countries = [
    {
        name: "France",
        code: "FR",
        region: "Europe",
        flag: new URL("../assets/flags/fr.svg", import.meta.url).href,
    },
    {
        name: "Germany",
        code: "DE",
        region: "Europe",
        flag: new URL("../assets/flags/de.svg", import.meta.url).href,
    },
    {
        name: "Japan",
        code: "JP",
        region: "Asia",
        flag: new URL("../assets/flags/jp.svg", import.meta.url).href,
    },
    { name: "Italy", code: "IT", region: "Europe", flag: new URL("../assets/flags/it.svg", import.meta.url).href },
    { name: "Belgium", code: "BE", region: "Europe", flag: new URL("../assets/flags/be.svg", import.meta.url).href },
    { name: "Netherlands", code: "NL", region: "Europe", flag: new URL("../assets/flags/nl.svg", import.meta.url).href },
    { name: "Ireland", code: "IE", region: "Europe", flag: new URL("../assets/flags/ie.svg", import.meta.url).href },
    { name: "Austria", code: "AT", region: "Europe", flag: new URL("../assets/flags/at.svg", import.meta.url).href },
    { name: "Poland", code: "PL", region: "Europe", flag: new URL("../assets/flags/pl.svg", import.meta.url).href },
    { name: "Ukraine", code: "UA", region: "Europe", flag: new URL("../assets/flags/ua.svg", import.meta.url).href },
    { name: "Nigeria", code: "NG", region: "Africa", flag: new URL("../assets/flags/ng.svg", import.meta.url).href },
    { name: "Indonesia", code: "ID", region: "Asia", flag: new URL("../assets/flags/id.svg", import.meta.url).href },
];
