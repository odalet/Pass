package com.sopra.passport.data;
/*
 * Copyright (C) 2012 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public enum CountryCode implements Serializable
{
	
	NOSELECTION("Not selected", "NOT SELECTED", 16),
    // @formatter:off
    /** <a href="http://en.wikipedia.org/wiki/Andorra">Andorra</a> */
    AND("Andorra", "AND", 16),

    /** <a href="http://en.wikipedia.org/wiki/United_Arab_Emirates">United Arab Emirates</a> */
    ARE("United Arab Emirates", "ARE", 784),

    /** <a href="http://en.wikipedia.org/wiki/Afghanistan">Afghanistan</a> */
    AFG("Afghanistan", "AFG", 4),

    /** <a href="http://en.wikipedia.org/wiki/Antigua_and_Barbuda">Antigua and Barbuda</a> */
    ATG("Antigua and Barbuda", "ATG", 28),

    /** <a href="http://en.wikipedia.org/wiki/Anguilla">Anguilla</a> */
    AIA("Anguilla", "AIA", 660),

    /** <a href="http://en.wikipedia.org/wiki/Albania">Albania</a> */
    ALB("Albania", "ALB", 8),

    /** <a href="http://en.wikipedia.org/wiki/Armenia">Armenia</a> */
    ARM("Armenia", "ARM", 51),

    /** <a href="http://en.wikipedia.org/wiki/Netherlands_Antilles">Netherlands Antilles</a> */
    ANT("Netherlands Antilles", "ANT", 530),

    /** <a href="http://en.wikipedia.org/wiki/Angola">Angola</a> */
    AGO("Angola", "AGO", 24),

    /** <a href="http://en.wikipedia.org/wiki/Antarctica">Antarctica</a> */
    ATA("Antarctica", "ATA", 10),

    /** <a href="http://en.wikipedia.org/wiki/Argentina">Argentina</a> */
    ARG("Argentina", "ARG", 32),

    /** <a href="http://en.wikipedia.org/wiki/American_Samoa">American Samoa</a> */
    ASM("American Samoa", "ASM", 16),

    /** <a href="http://en.wikipedia.org/wiki/Austria">Austria</a> */
    AUT("Austria", "AUT", 40),

    /** <a href="http://en.wikipedia.org/wiki/Australia">Australia</a> */
    AUS("Australia", "AUS", 36),

    /** <a href="http://en.wikipedia.org/wiki/Aruba">Aruba</a> */
    ABW("Aruba", "ABW", 533),

    /** <a href="http://en.wikipedia.org/wiki/%C3%85land_Islands">&Aring;land Islands</a> */
    ALA("\u212Bland Islands", "ALA", 248),

    /** <a href="http://en.wikipedia.org/wiki/Azerbaijan">Azerbaijan</a> */
    AZE("Azerbaijan", "AZE", 31),

    /** <a href="http://en.wikipedia.org/wiki/Bosnia_and_Herzegovina">Bosnia and Herzegovina</a> */
    BIH("Bosnia and Herzegovina", "BIH", 70),

    /** <a href="http://en.wikipedia.org/wiki/Barbados">Barbados</a> */
    BRB("Barbados", "BRB", 52),

    /** <a href="http://en.wikipedia.org/wiki/Bangladesh">Bangladesh</a> */
    BGD("Bangladesh", "BGD", 50),

    /** <a href="http://en.wikipedia.org/wiki/Belgium">Belgium</a> */
    BEL("Belgium", "BEL", 56),

    /** <a href="http://en.wikipedia.org/wiki/Burkina_Faso">Burkina Faso</a> */
    BFA("Burkina Faso", "BFA", 854),

    /** <a href="http://en.wikipedia.org/wiki/Bulgaria">Bulgaria</a> */
    BGR("Bulgaria", "BGR", 100),

    /** <a href="http://en.wikipedia.org/wiki/Bahrain">Bahrain</a> */
    BHR("Bahrain", "BHR", 48),

    /** <a href="http://en.wikipedia.org/wiki/Burundi">Burundi</a> */
    BDI("Burundi", "BDI", 108),

    /** <a href="http://en.wikipedia.org/wiki/Benin">Benin</a> */
    BEN("Benin", "BEN", 204),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Barth%C3%A9lemy">Saint Barth&eacute;lemy</a> */
    BLM("Saint Barth\u00E9lemy", "BLM", 652),

    /** <a href="http://en.wikipedia.org/wiki/Bermuda">Bermuda</a> */
    BMU("Bermuda", "BMU", 60),

    /** <a href="http://en.wikipedia.org/wiki/Brunei">Brunei Darussalam</a> */
    BRN("Brunei Darussalam", "BRN", 96),

    /** <a href="http://en.wikipedia.org/wiki/Bolivia">Plurinational State of Bolivia</a> */
    BOL("Plurinational State of Bolivia", "BOL", 68),

    /** <a href="http://en.wikipedia.org/wiki/Caribbean_Netherlands">Bonaire, Sint Eustatius and Saba</a> */
    BES("Bonaire, Sint Eustatius and Saba", "BES", 535),

    /** <a href="http://en.wikipedia.org/wiki/Brazil">Brazil</a> */
    BRA("Brazil", "BRA", 76),

    /** <a href="http://en.wikipedia.org/wiki/The_Bahamas">Bahamas</a> */
    BHS("Bahamas", "BHS", 44),

    /** <a href="http://en.wikipedia.org/wiki/Bhutan">Bhutan</a> */
    BTN("Bhutan", "BTN", 64),

    /** <a href="http://en.wikipedia.org/wiki/Bouvet_Island">Bouvet Island</a> */
    BVT("Bouvet Island", "BVT", 74),

    /** <a href="http://en.wikipedia.org/wiki/Botswana">Botswana</a> */
    BWA("Botswana", "BWA", 72),

    /** <a href="http://en.wikipedia.org/wiki/Belarus">Belarus</a> */
    BLR("Belarus", "BLR", 112),

    /** <a href="http://en.wikipedia.org/wiki/Belize">Belize</a> */
    BLZ("Belize", "BLZ", 84),

    /** <a href="http://en.wikipedia.org/wiki/Canada">Canada</a> */
    CA("Canada", "CAN", 124),

    /** <a href="http://en.wikipedia.org/wiki/Cocos_(Keeling)_Islands">Cocos (Keeling) Islands</a> */
    CCK("Cocos Islands", "CCK", 166),

    /** <a href="http://en.wikipedia.org/wiki/Democratic_Republic_of_the_Congo">The Democratic Republic of the Congo</a> */
    COD("The Democratic Republic of the Congo", "COD", 180),

    /** <a href="http://en.wikipedia.org/wiki/Central_African_Republic">Central African Republic</a> */
    CF("Central African Republic", "CAF", 140),

    /** <a href="http://en.wikipedia.org/wiki/Republic_of_the_Congo">Congo</a> */
    CG("Congo", "COG", 178),

    /** <a href="http://en.wikipedia.org/wiki/Switzerland">Switzerland</a> */
    CH("Switzerland", "CHE", 756),

    /** <a href="http://en.wikipedia.org/wiki/C%C3%B4te_d%27Ivoire">C&ocirc;te d'Ivoire</a> */
    CI("C\u00F4te d'Ivoire", "CIV", 384),

    /** <a href="http://en.wikipedia.org/wiki/Cook_Islands">Cook Islands</a> */
    CK("Cook Islands", "COK", 184),

    /** <a href="http://en.wikipedia.org/wiki/Chile">Chile</a> */
    CL("Chile", "CHL", 152),

    /** <a href="http://en.wikipedia.org/wiki/Cameroon">Cameroon</a> */
    CM("Cameroon", "CMR", 120),

    /** <a href="http://en.wikipedia.org/wiki/China">China</a> */
    CN("China", "CHN", 156),

    /** <a href="http://en.wikipedia.org/wiki/Colombia">Colombia</a> */
    CO("Colombia", "COL", 170),

    /** <a href="http://en.wikipedia.org/wiki/Costa_Rica">Costa Rica</a> */
    CR("Costa Rica", "CRI", 188),

    /** <a href="http://en.wikipedia.org/wiki/Cuba">Cuba</a> */
    CU("Cuba", "CUB", 192),

    /** <a href="http://en.wikipedia.org/wiki/Cape_Verde">Cape Verde</a> */
    CV("Cape Verde", "CPV", 132),

    /** <a href="http://en.wikipedia.org/wiki/Cura%C3%A7ao">Cura&ccedil;ao</a> */
    CW("Cura/u00E7ao", "CUW", 531),

    /** <a href="http://en.wikipedia.org/wiki/Christmas_Island">Christmas Island</a> */
    CX("Christmas Island", "CXR", 162),

    /** <a href="http://en.wikipedia.org/wiki/Cyprus">Cyprus</a> */
    CY("Cyprus", "CYP", 196),

    /** <a href="http://en.wikipedia.org/wiki/Czech_Republic">Czech Republic</a> */
    CZ("Czech Republic", "CZE", 203),

    /** <a href="http://en.wikipedia.org/wiki/Germany">Germany</a> */
    DE("Germany", "DEU", 276),

    /** <a href="http://en.wikipedia.org/wiki/Djibouti">Djibouti </a> */
    DJ("Djibouti", "DJI", 262),

    /** <a href="http://en.wikipedia.org/wiki/Denmark">Denmark</a> */
    DK("Denmark", "DNK", 208),

    /** <a href="http://en.wikipedia.org/wiki/Dominica">Dominica</a> */
    DMA("Dominica", "DMA", 212),

    /** <a href="http://en.wikipedia.org/wiki/Dominican_Republic">Dominican Republic</a> */
    DOM("Dominican Republic", "DOM", 214),

    /** <a href="http://en.wikipedia.org/wiki/Algeria">Algeria</a> */
    DZA("Algeria", "DZA", 12),

    /** <a href="http://en.wikipedia.org/wiki/Ecuador">Ecuador</a> */
    EC("Ecuador", "ECU", 218),

    /** <a href="http://en.wikipedia.org/wiki/Estonia">Estonia</a> */
    EE("Estonia", "EST", 233),

    /** <a href="http://en.wikipedia.org/wiki/Egypt">Egypt</a> */
    EG("Egypt", "EGY", 818),

    /** <a href="http://en.wikipedia.org/wiki/Western_Sahara">Western Sahara</a> */
    EH("Western Sahara", "ESH", 732),

    /** <a href="http://en.wikipedia.org/wiki/Eritrea">Eritrea</a> */
    ER("Eritrea", "ERI", 232),

    /** <a href="http://en.wikipedia.org/wiki/Spain">Spain</a> */
    ES("Spain", "ESP", 724),

    /** <a href="http://en.wikipedia.org/wiki/Ethiopia">Ethiopia</a> */
    ET("Ethiopia", "ETH", 231),

    /** <a href="http://en.wikipedia.org/wiki/Finland">Finland</a> */
    FI("Finland", "FIN", 246),

    /** <a href="http://en.wikipedia.org/wiki/Fiji">Fiji</a> */
    FJ("Fiji", "FJI", 242),

    /** <a href="http://en.wikipedia.org/wiki/Falkland_Islands">Falkland Islands (Malvinas)</a> */
    FK("Falkland Islands", "FLK", 238),

    /** <a href="http://en.wikipedia.org/wiki/Federated_States_of_Micronesia">Federated States of Micronesia</a> */
    FM("Federated States of Micronesia", "FSM", 583),

    /** <a href="http://en.wikipedia.org/wiki/Faroe_Islands">Faroe Islands</a> */
    FRO("Faroe Islands", "FRO", 234),

    /** <a href="http://en.wikipedia.org/wiki/France">France</a> */
    FRA("France", "FRA", 250),

    /** <a href="http://en.wikipedia.org/wiki/Gabon">Gabon </a> */
    GAB("Gabon", "GAB", 266),

    /** <a href="http://en.wikipedia.org/wiki/United_Kingdom">United Kingdom</a> */
    GB("United Kingdom", "GBR", 826),

    /** <a href="http://en.wikipedia.org/wiki/Grenada">Grenada</a> */
    GD("Grenada", "GRD", 308),

    /** <a href="http://en.wikipedia.org/wiki/Georgia_(country)">Georgia</a> */
    GE("Georgia", "GEO", 268),

    /** <a href="http://en.wikipedia.org/wiki/French_Guiana">French Guiana</a> */
    GF("French Guiana", "GUF", 254),

    /** <a href="http://en.wikipedia.org/wiki/Guernsey">Guemsey</a> */
    GG("Guemsey", "GGY", 831),

    /** <a href="http://en.wikipedia.org/wiki/Ghana">Ghana</a> */
    GH("Ghana", "GHA", 288),

    /** <a href="http://en.wikipedia.org/wiki/Gibraltar">Gibraltar</a> */
    GI("Gibraltar", "GIB", 292),

    /** <a href="http://en.wikipedia.org/wiki/Greenland">Greenland</a> */
    GL("Greenland", "GRL", 304),

    /** <a href="http://en.wikipedia.org/wiki/The_Gambia">Gambia</a> */
    GM("Gambia", "GMB", 270),

    /** <a href="http://en.wikipedia.org/wiki/Guinea">Guinea</a> */
    GN("Guinea", "GIN", 324),

    /** <a href="http://en.wikipedia.org/wiki/Guadeloupe">Guadeloupe</a> */
    GP("Guadeloupe", "GLP", 312),

    /** <a href="http://en.wikipedia.org/wiki/Equatorial_Guinea">Equatorial Guinea</a> */
    GQ("Equatorial Guinea", "GNQ", 226),

    /** <a href="http://en.wikipedia.org/wiki/Greece">Greece</a> */
    GR("Greece", "GRC", 300),

    /** <a href="http://en.wikipedia.org/wiki/South_Georgia_and_the_South_Sandwich_Islands">South Georgia and the South Sandwich Islands</a> */
    GS("South Georgia and the South Sandwich Islands", "SGS", 239),

    /** <a href="http://en.wikipedia.org/wiki/Guatemala">Guatemala</a> */
    GT("Guatemala", "GTM", 320),

    /** <a href="http://en.wikipedia.org/wiki/Guam">Guam</a> */
    GU("Guam", "GUM", 316),

    /** <a href="http://en.wikipedia.org/wiki/Guinea-Bissau">Guinea-Bissau</a> */
    GW("Guinea-Bissau", "GNB", 624),

    /** <a href="http://en.wikipedia.org/wiki/Guyana">Guyana</a> */
    GY("Guyana", "GUY", 328),

    /** <a href="http://en.wikipedia.org/wiki/Hong_Kong">Hong Kong</a> */
    HK("Hong Kong", "HKG", 344),

    /** <a href="http://en.wikipedia.org/wiki/Heard_Island_and_McDonald_Islands">Heard Island and McDonald Islands</a> */
    HM("Heard Island and McDonald Islands", "HMD", 334),

    /** <a href="http://en.wikipedia.org/wiki/Honduras">Honduras</a> */
    HN("Honduras", "HND", 340),

    /** <a href="http://en.wikipedia.org/wiki/Croatia">Croatia</a> */
    HR("Croatia", "HRV", 191),

    /** <a href="http://en.wikipedia.org/wiki/Haiti">Haiti</a> */
    HT("Haiti", "HTI", 332),

    /** <a href="http://en.wikipedia.org/wiki/Hungary">Hungary</a> */
    HU("Hungary", "HUN", 348),

    /** <a href="http://en.wikipedia.org/wiki/Indonesia">Indonesia</a> */
    ID("Indonesia", "IDN", 360),

    /** <a href="http://en.wikipedia.org/wiki/Republic_of_Ireland">Ireland</a> */
    IE("Ireland", "IRL", 372),

    /** <a href="http://en.wikipedia.org/wiki/Israel">Israel</a> */
    ISR("Israel", "ISR", 376),

    /** <a href="http://en.wikipedia.org/wiki/Isle_of_Man">Isle of Man</a> */
    IM("Isle of Man", "IMN", 833),

    /** <a href="http://en.wikipedia.org/wiki/India">India</a> */
    IN("India", "IND", 356),

    /** <a href="http://en.wikipedia.org/wiki/British_Indian_Ocean_Territory">British Indian Ocean Territory</a> */
    IO("British Indian Ocean Territory", "IOT", 86),

    /** <a href="http://en.wikipedia.org/wiki/Iraq">Iraq</a> */
    IQ("Iraq", "IRQ", 368),

    /** <a href="http://en.wikipedia.org/wiki/Iran">Islamic Republic of Iran</a> */
    IR("Islamic Republic of Iran", "IRN", 364),

    /** <a href="http://en.wikipedia.org/wiki/Iceland">Iceland</a> */
    IS("Iceland", "ISL", 352),

    /** <a href="http://en.wikipedia.org/wiki/Italy">Italy</a> */
    IT("Italy", "ITA", 380),

    /** <a href="http://en.wikipedia.org/wiki/Jersey">Jersey</a> */
    JE("Jersey", "JEY", 832),

    /** <a href="http://en.wikipedia.org/wiki/Jamaica">Jamaica</a> */
    JM("Jamaica", "JAM", 388),

    /** <a href="http://en.wikipedia.org/wiki/Jordan">Jordan</a> */
    JO("Jordan", "JOR", 400),

    /** <a href="http://en.wikipedia.org/wiki/Japan">Japan</a> */
    JP("Japan", "JPN", 392),

    /** <a href="http://en.wikipedia.org/wiki/Kenya">Kenya</a> */
    KE("Kenya", "KEN", 404),

    /** <a href="http://en.wikipedia.org/wiki/Kyrgyzstan">Kyrgyzstan</a> */
    KG("Kyrgyzstan", "KGZ", 417),

    /** <a href="http://en.wikipedia.org/wiki/Cambodia">Cambodia</a> */
    KH("Cambodia", "KHM", 116),

    /** <a href="http://en.wikipedia.org/wiki/Kiribati">Kiribati</a> */
    KI("Kiribati", "KIR", 296),

    /** <a href="http://en.wikipedia.org/wiki/Comoros">Comoros</a> */
    KM("Comoros", "COM", 174),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Kitts_and_Nevis">Saint Kitts and Nevis</a> */
    KN("Saint Kitts and Nevis", "KNA", 659),

    /** <a href="http://en.wikipedia.org/wiki/North_Korea">Democratic People's Republic of Korea</a> */
    KP("Democratic People's Republic of Korea", "PRK", 408),

    /** <a href="http://en.wikipedia.org/wiki/South_Korea">Republic of Korea</a> */
    KR("Republic of Korea", "KOR", 410),

    /** <a href="http://en.wikipedia.org/wiki/Kuwait">Kuwait</a> */
    KW("Kuwait", "KWT", 414),

    /** <a href="http://en.wikipedia.org/wiki/Cayman_Islands">Cayman Islands</a> */
    KY("Cayman Islands", "CYM", 136),

    /** <a href="http://en.wikipedia.org/wiki/Kazakhstan">Kazakhstan</a> */
    KZ("Kazakhstan", "KAZ", 398),

    /** <a href="http://en.wikipedia.org/wiki/Laos">Lao People's Democratic Republic</a> */
    LA("Lao People's Democratic Republic", "LAO", 418),

    /** <a href="http://en.wikipedia.org/wiki/Lebanon">Lebanon</a> */
    LBN("Lebanon", "LBN", 422),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Lucia">Saint Lucia</a> */
    LC("Saint Lucia", "LCA", 662),

    /** <a href="http://en.wikipedia.org/wiki/Liechtenstein">Liechtenstein</a> */
    LIE("Liechtenstein", "LIE", 438),

    /** <a href="http://en.wikipedia.org/wiki/Sri_Lanka">Sri Lanka</a> */
    LK("Sri Lanka", "LKA", 144),

    /** <a href="http://en.wikipedia.org/wiki/Liberia">Liberia</a> */
    LR("Liberia", "LBR", 430),

    /** <a href="http://en.wikipedia.org/wiki/Lesotho">Lesotho</a> */
    LS("Lesotho", "LSO", 426),

    /** <a href="http://en.wikipedia.org/wiki/Lithuania">Lithuania</a> */
    LTU("Lithuania", "LTU", 440),

    /** <a href="http://en.wikipedia.org/wiki/Luxembourg">Luxembourg</a> */
    LUX("Luxembourg", "LUX", 442),

    /** <a href="http://en.wikipedia.org/wiki/Latvia">Latvia</a> */
    LVA("Latvia", "LVA", 428),

    /** <a href="http://en.wikipedia.org/wiki/Libya">Libya</a> */
    LBY("Libya", "LBY", 434),

    /** <a href="http://en.wikipedia.org/wiki/Morocco">Morocco</a> */
    MAR("Morocco", "MAR", 504),

    /** <a href="http://en.wikipedia.org/wiki/Monaco">Monaco</a> */
    MC("Monaco", "MCO", 492),

    /** <a href="http://en.wikipedia.org/wiki/Moldova">Republic of Moldova</a> */
    MDA("Republic of Moldova", "MDA", 498),

    /** <a href="http://en.wikipedia.org/wiki/Montenegro">Montenegro</a> */
    ME("Montenegro", "MNE", 499),

    /** <a href="http://en.wikipedia.org/wiki/Collectivity_of_Saint_Martin">Saint Martin (French part)</a> */
    MF("Saint Martin", "MAF", 663),

    /** <a href="http://en.wikipedia.org/wiki/Madagascar">Madagascar</a> */
    MG("Madagascar", "MDG",450),

    /** <a href="http://en.wikipedia.org/wiki/Marshall_Islands">Marshall Islands</a> */
    MH("Marshall Islands", "MHL", 584),

    /** <a href="http://en.wikipedia.org/wiki/Republic_of_Macedonia">The former Yugoslav Republic of Macedonia</a> */
    MK("The former Yugoslav Republic of Macedonia", "MKD", 807),

    /** <a href="http://en.wikipedia.org/wiki/Mali">Mali</a> */
    ML("Mali", "MLI", 466),

    /** <a href="http://en.wikipedia.org/wiki/Myanmar">Myanmar</a> */
    MM("Myanmar", "MMR", 104),

    /** <a href="http://en.wikipedia.org/wiki/Mongolia">Mongolia</a> */
    MN("Mongolia", "MNG", 496),

    /** <a href="http://en.wikipedia.org/wiki/Macau">Macao</a> */
    MO("Macao", "MCO", 492),

    /** <a href="http://en.wikipedia.org/wiki/Northern_Mariana_Islands">Northern Mariana Islands</a> */
    MP("Northern Mariana Islands", "MNP",580),

    /** <a href="http://en.wikipedia.org/wiki/Martinique">Martinique</a> */
    MQ("Martinique", "MTQ", 474),

    /** <a href="http://en.wikipedia.org/wiki/Mauritania">Mauritania</a> */
    MR("Mauritania", "MRT", 478),

    /** <a href="http://en.wikipedia.org/wiki/Montserrat">Montserrat</a> */
    MS("Montserrat", "MSR", 500),

    /** <a href="http://en.wikipedia.org/wiki/Malta">Malta</a> */
    MT("Malta", "MLT", 470),

    /** <a href="http://en.wikipedia.org/wiki/Mauritius">Mauritius</a> */
    MUS("Mauritius", "MUS", 480),

    /** <a href="http://en.wikipedia.org/wiki/Maldives">Maldives</a> */
    MDV("Maldives", "MDV", 462),

    /** <a href="http://en.wikipedia.org/wiki/Malawi">Malawi</a> */
    MWI("Malawi", "MWI", 454),

    /** <a href="http://en.wikipedia.org/wiki/Mexico">Mexico</a> */
    MEX("Mexico", "MEX", 484),

    /** <a href="http://en.wikipedia.org/wiki/Malaysia">Malaysia</a> */
    MY("Malaysia", "MYS", 458),

    /** <a href="http://en.wikipedia.org/wiki/Mozambique">Mozambique</a> */
    MOZ("Mozambique", "MOZ", 508),

    /** <a href="http://en.wikipedia.org/wiki/Namibia">Namibia</a> */
    NAM("Namibia", "NAM", 516),

    /** <a href="http://en.wikipedia.org/wiki/New_Caledonia">New Caledonia</a> */
    NCL("New Caledonia", "NCL", 540),

    /** <a href="http://en.wikipedia.org/wiki/Niger">Niger</a> */
    NER("Niger", "NER", 562),

    /** <a href="http://en.wikipedia.org/wiki/Norfolk_Island">Norfolk Island</a> */
    NFK("Norfolk Island", "NFK", 574),

    /** <a href="http://en.wikipedia.org/wiki/Nigeria">Nigeria</a> */
    NGA("Nigeria","NGA", 566),

    /** <a href="http://en.wikipedia.org/wiki/Nicaragua">Nicaragua</a> */
    NIC("Nicaragua", "NIC", 558),

    /** <a href="http://en.wikipedia.org/wiki/Netherlands">Netherlands</a> */
    NLD("Netherlands", "NLD", 528),

    /** <a href="http://en.wikipedia.org/wiki/Norway">Norway</a> */
    NOR("Norway", "NOR", 578),

    /** <a href="http://en.wikipedia.org/wiki/Nepal">Nepal</a> */
    NPL("Nepal", "NPL", 524),

    /** <a href="http://en.wikipedia.org/wiki/Nauru">Nauru</a> */
    NRU("Nauru", "NRU", 520),

    /** <a href="http://en.wikipedia.org/wiki/Niue">Niue</a> */
    NIU("Niue", "NIU", 570),

    /** <a href="http://en.wikipedia.org/wiki/New_Zealand">New Zealand</a> */
    NZL("New Zealand", "NZL", 554),

    /** <a href=http://en.wikipedia.org/wiki/Oman"">Oman</a> */
    OMN("Oman", "OMN", 512),

    /** <a href="http://en.wikipedia.org/wiki/Panama">Panama</a> */
    PAN("Panama", "PAN", 591),

    /** <a href="http://en.wikipedia.org/wiki/Peru">Peru</a> */
    PE("Peru", "PER", 604),

    /** <a href="http://en.wikipedia.org/wiki/French_Polynesia">French Polynesia</a> */
    PF("French Polynesia", "PYF", 258),

    /** <a href="http://en.wikipedia.org/wiki/Papua_New_Guinea">Papua New Guinea</a> */
    PG("Papua New Guinea", "PNG", 598),

    /** <a href="http://en.wikipedia.org/wiki/Philippines">Philippines</a> */
    PH("Philippines", "PHL", 608),

    /** <a href="http://en.wikipedia.org/wiki/Pakistan">Pakistan</a> */
    PK("Pakistan", "PAK", 586),

    /** <a href="http://en.wikipedia.org/wiki/Poland">Poland</a> */
    PL("Poland", "POL", 616),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Pierre_and_Miquelon">Saint Pierre and Miquelon</a> */
    PM("Saint Pierre and Miquelon", "SPM", 666),

    /** <a href="http://en.wikipedia.org/wiki/Pitcairn_Islands">Pitcairn</a> */
    PN("Pitcairn", "PCN", 612),

    /** <a href="http://en.wikipedia.org/wiki/Puerto_Rico">Puerto Rico</a> */
    PR("Puerto Rico", "PRI", 630),

    /** <a href="http://en.wikipedia.org/wiki/Palestinian_territories">Occupied Palestinian Territory</a> */
    PSE("Occupied Palestinian Territory", "PSE", 275),

    /** <a href="http://en.wikipedia.org/wiki/Portugal">Portugal</a> */
    PRT("Portugal", "PRT", 620),

    /** <a href="http://en.wikipedia.org/wiki/Palau">Palau</a> */
    PLW("Palau", "PLW", 585),

    /** <a href="http://en.wikipedia.org/wiki/Paraguay">Paraguay</a> */
    PRY("Paraguay", "PRY", 600),

    /** <a href="http://en.wikipedia.org/wiki/Qatar">Qatar</a> */
    QAT("Qatar", "QAT", 634),

    /** <a href="http://en.wikipedia.org/wiki/R%C3%A9union">R&eacute;union</a> */
    REU("R\u00E9union", "REU", 638),

    /** <a href="http://en.wikipedia.org/wiki/Romania">Romania</a> */
    ROU("Romania", "ROU", 642),

    /** <a href="http://en.wikipedia.org/wiki/Serbia">Serbia</a> */
    SRB("Serbia", "SRB", 688),

    /** <a href="http://en.wikipedia.org/wiki/Russia">Russian Federation</a> */
    RUS("Russian Federation", "RUS", 643),

    /** <a href="http://en.wikipedia.org/wiki/Rwanda">Rwanda</a> */
    RW("Rwanda", "RWA", 646),

    /** <a href="http://en.wikipedia.org/wiki/Saudi_Arabia">Saudi Arabia</a> */
    SA("Saudi Arabia", "SAU", 682),

    /** <a href="http://en.wikipedia.org/wiki/Solomon_Islands">Solomon Islands</a> */
    SB("Solomon Islands", "SLB", 90),

    /** <a href="http://en.wikipedia.org/wiki/Seychelles">Seychelles</a> */
    SC("Seychelles", "SYC", 690),

    /** <a href="http://en.wikipedia.org/wiki/Sudan">Sudan</a> */
    SD("Sudan", "SDN", 729),

    /** <a href="http://en.wikipedia.org/wiki/Sweden">Sweden</a> */
    SE("Sweden", "SWE", 752),

    /** <a href="http://en.wikipedia.org/wiki/Singapore">Singapore</a> */
    SG("Singapore", "SGP", 702),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Helena,_Ascension_and_Tristan_da_Cunha">Saint Helena, Ascension and Tristan da Cunha</a> */
    SH("Saint Helena, Ascension and Tristan da Cunha", "SHN", 654),

    /** <a href="http://en.wikipedia.org/wiki/Slovenia">Slovenia</a> */
    SI("Slovenia", "SVN", 705),

    /** <a href="http://en.wikipedia.org/wiki/Svalbard_and_Jan_Mayen">Svalbard and Jan Mayen</a> */
    SJ("Svalbard and Jan Mayen", "SJM", 744),

    /** <a href="http://en.wikipedia.org/wiki/Slovakia">Slovakia</a> */
    SK("Slovakia", "SVK", 703),

    /** <a href="http://en.wikipedia.org/wiki/Sierra_Leone">Sierra Leone</a> */
    SL("Sierra Leone", "SLE", 694),

    /** <a href="http://en.wikipedia.org/wiki/San_Marino">San Marino</a> */
    SM("San Marino", "SMR", 674),

    /** <a href="http://en.wikipedia.org/wiki/Senegal">Senegal</a> */
    SN("Senegal", "SEN", 686),

    /** <a href="http://en.wikipedia.org/wiki/Somalia">Somalia</a> */
    SO("Somalia", "SOM", 706),

    /** <a href="http://en.wikipedia.org/wiki/Suriname">Suriname</a> */
    SR("Suriname", "SUR", 740),

    /** <a href="http://en.wikipedia.org/wiki/South_Sudan">South Sudan</a> */
    SS("South Sudan", "SSD", 728),

    /** <a href="http://en.wikipedia.org/wiki/S%C3%A3o_Tom%C3%A9_and_Pr%C3%ADncipe">Sao Tome and Principe</a> */
    ST("Sao Tome and Principe", "STP", 678),

    /** <a href="http://en.wikipedia.org/wiki/El_Salvador">El Salvador</a> */
    SV("El Salvador", "SLV", 222),

    /** <a href="http://en.wikipedia.org/wiki/Sint_Maarten">Sint Maarten (Dutch part)</a> */
    SX("Sint Maarten", "SXM", 534),

    /** <a href="http://en.wikipedia.org/wiki/Syria">Syrian Arab Republic</a> */
    SY("Syrian Arab Republic", "SYR", 760),

    /** <a href="http://en.wikipedia.org/wiki/Swaziland">Swaziland</a> */
    SZ("Swaziland", "SWZ", 748),

    /** <a href="http://en.wikipedia.org/wiki/Turks_and_Caicos_Islands">Turks and Caicos Islands</a> */
    TC("Turks and Caicos Islands", "TCA", 796),

    /** <a href="http://en.wikipedia.org/wiki/Chad">Chad</a> */
    TD("Chad", "TCD", 148),

    /** <a href="http://en.wikipedia.org/wiki/French_Southern_and_Antarctic_Lands">French Southern Territories</a> */
    TF("French Southern Territories", "ATF", 260),

    /** <a href="http://en.wikipedia.org/wiki/Togo">Togo</a> */
    TG("Togo", "TGO", 768),

    /** <a href="http://en.wikipedia.org/wiki/Thailand">Thailand</a> */
    TH("Thailand", "THA", 764),

    /** <a href="http://en.wikipedia.org/wiki/Tajikistan">Tajikistan</a> */
    TJ("Tajikistan", "TJK", 762),

    /** <a href="http://en.wikipedia.org/wiki/Tokelau">Tokelau</a> */
    TK("Tokelau", "TKL", 772),

    /** <a href="http://en.wikipedia.org/wiki/East_Timor">Timor-Leste</a> */
    TL("Timor-Leste", "TLS", 626),

    /** <a href="http://en.wikipedia.org/wiki/Turkmenistan">Turkmenistan</a> */
    TM("Turkmenistan", "TKM", 795),

    /** <a href="http://en.wikipedia.org/wiki/Tunisia">Tunisia</a> */
    TN("Tunisia", "TUN", 788),

    /** <a href="http://en.wikipedia.org/wiki/Tonga">Tonga</a> */
    TO("Tonga", "TON", 776),

    /** <a href="http://en.wikipedia.org/wiki/Turkey">Turkey</a> */
    TR("Turkey", "TUR", 792),

    /** <a href="http://en.wikipedia.org/wiki/Trinidad_and_Tobago">Trinidad and Tobago</a> */
    TT("Trinidad and Tobago", "TTO", 780),

    /** <a href="http://en.wikipedia.org/wiki/Tuvalu">Tuvalu</a> */
    TV("Tuvalu", "TUV", 798),

    /** <a href="http://en.wikipedia.org/wiki/Taiwan">Taiwan, Province of China</a> */
    TW("Taiwan, Province of China", "TWN", 158),

    /** <a href="http://en.wikipedia.org/wiki/Tanzania">United Republic of Tanzania</a> */
    TZ("United Republic of Tanzania", "TZA", 834),

    /** <a href="http://en.wikipedia.org/wiki/Ukraine">Ukraine</a> */
    UA("Ukraine", "UKR", 804),

    /** <a href="http://en.wikipedia.org/wiki/Uganda">Uganda</a> */
    UGA("Uganda", "UGA", 800),

    /** <a href="http://en.wikipedia.org/wiki/United_States_Minor_Outlying_Islands">United States Minor Outlying Islands</a> */
    UMI("United States Minor Outlying Islands", "UMI", 581),

    /** <a href="http://en.wikipedia.org/wiki/United_States">United States</a> */
    USA("United States", "USA", 840),

    /** <a href="http://en.wikipedia.org/wiki/Uruguay">Uruguay</a> */
    UY("Uruguay", "URY", 858),

    /** <a href="http://en.wikipedia.org/wiki/Uzbekistan">Uzbekistan</a> */
    UZ("Uzbekistan", "UZB", 860),

    /** <a href="http://en.wikipedia.org/wiki/Vatican_City">Holy See (Vatican City State)</a> */
    VA("Holy See", "VAT", 336),

    /** <a href="http://en.wikipedia.org/wiki/Saint_Vincent_and_the_Grenadines">Saint Vincent and the Grenadines</a> */
    VCT("Saint Vincent and the Grenadines", "VCT", 670),

    /** <a href="http://en.wikipedia.org/wiki/Venezuela">Bolivarian Republic of Venezuela</a> */
    VEN("Bolivarian Republic of Venezuela", "VEN", 862),

    /** <a href="http://en.wikipedia.org/wiki/British_Virgin_Islands">British Virgin Islands</a> */
    VGB("British Virgin Islands", "VGB", 92),

    /** <a href="http://en.wikipedia.org/wiki/United_States_Virgin_Islands">Virgin Islands, U.S.</a> */
    VI("Virgin Islands, U.S.", "VIR", 850),

    /** <a href="http://en.wikipedia.org/wiki/Vietnam">Viet Nam</a> */
    VN("Viet Nam", "VNM", 704),

    /** <a href="http://en.wikipedia.org/wiki/Vanuatu">Vanuatu</a> */
    VU("Vanuatu", "VUT", 548),

    /** <a href="http://en.wikipedia.org/wiki/Wallis_and_Futuna">Wallis and Futuna</a> */
    WF("Wallis and Futuna", "WLF", 876),

    /** <a href="http://en.wikipedia.org/wiki/Samoa">Samoa</a> */
    WS("Samoa", "WSM", 882),

    /** <a href="http://en.wikipedia.org/wiki/Yemen">Yemen</a> */
    YE("Yemen", "YEM", 887),

    /** <a href="http://en.wikipedia.org/wiki/Mayotte">Mayotte</a> */
    YT("Mayotte", "MYT", 175),

    /** <a href="http://en.wikipedia.org/wiki/South_Africa">South Africa</a> */
    ZA("South Africa", "ZAF", 710),

    /** <a href="http://en.wikipedia.org/wiki/Zambia">Zambia</a> */
    ZM("Zambia", "ZMB", 894),

    /** <a href="http://en.wikipedia.org/wiki/Zimbabwe">Zimbabwe</a> */
    ZW("Zimbabwe", "ZWE", 716);
    // @formatter:on


    private static final Map<String, CountryCode> alpha3Map = new HashMap<String, CountryCode>();
    private static final Map<Integer, CountryCode> numericMap = new HashMap<Integer, CountryCode>();


    static
    {
        for (CountryCode cc : values())
        {
            alpha3Map.put(cc.getAlpha3(), cc);
            numericMap.put(cc.getNumeric(), cc);
        }
    }


    private final String name;
    private final String alpha3;
    private final int numeric;


    private CountryCode(String name, String alpha3, int numeric)
    {
        this.name = name;
        this.alpha3 = alpha3;
        this.numeric = numeric;
    }


    /**
     * Get the country name.
     *
     * @return
     *         The country name.
     */
    public String getCountrName()
    {
        return name;
    }

    /**
     * Get the <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3"
     * >ISO 3166-1 alpha-3</a> code.
     *
     * @return
     *         The <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3"
     *         >ISO 3166-1 alpha-3</a> code.
     */
    public String getAlpha3()
    {
        return alpha3;
    }


    /**
     * Get the <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric"
     * >ISO 3166-1 numeric</a> code.
     *
     * @return
     *         The <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric"
     *         >ISO 3166-1 numeric</a> code.
     */
    public int getNumeric()
    {
        return numeric;
    }


    /**
     * Get a CountryCode that corresponds to a given ISO 3166-1
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">alpha-2</a> or
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3">alpha-3</a> code.
     *
     * @param code
     *         An ISO 3166-1 <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
     *         >alpha-2</a> or <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3"
     *         >alpha-3</a> code.
     *
     * @return
     *         A CountryCode instance, or null if not found.
     */
    public static CountryCode getByCode(String code)
    {
        if (code == null)
        {
            return null;
        }

        return getByAlpha3Code(code);

        
    }


   


    private static CountryCode getByAlpha3Code(String code)
    {
        return alpha3Map.get(code);
    }


    /**
     * Get a CountryCode that corresponds to a given
     * <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric">ISO 3166-1
     * numeric</a> code.
     *
     * @param code
     *         An <a href="http://en.wikipedia.org/wiki/ISO_3166-1_numeric"
     *         >ISO 3166-1 numeric</a> code.
     *
     * @return
     *         A CountryCode instance, or null if not found.
     */
    public static CountryCode getByCode(int code)
    {
        return numericMap.get(code);
    }
    
    @Override
    public String toString() {
    	return name;
    }
    
    public boolean equals(CountryCode code){
    	if(name == code.name || code == NOSELECTION){
    		return true;
    	}
    	return false;
    }
    

}
