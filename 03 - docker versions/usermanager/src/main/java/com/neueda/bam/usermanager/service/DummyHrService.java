package com.neueda.bam.usermanager.service;

import com.neueda.bam.usermanager.domain.HRUser;
import com.neueda.bam.usermanager.domain.HRUserList;
import com.neueda.bam.usermanager.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyHrService {

    private List<HRUser> users;
    private int lastUsed = 0;

    public DummyHrService() {
        users = new ArrayList<>();
        List<String> u = userList1.lines().toList();
        for (String it : u) {
            String[] parts = it.split("\\|");
            HRUser user = new HRUser();
            HRUser.Name name = new HRUser.Name();
            name.setFirst(parts[3].trim());
            name.setLast(parts[4].trim());
            name.setTitle(parts[5].trim());
            user.setName(name);
            user.setEmail(parts[2].trim());
            HRUser.Location location = new HRUser.Location();
            String[] address = parts[1].trim().split(",");
            HRUser.Street street = new HRUser.Street();
            street.setNumber(Integer.parseInt(address[0].trim().split(" ")[0].trim()));
            street.setName(address[0].trim().substring(address[0].trim().indexOf(" ")).trim());
            location.setStreet(street);
            location.setCity(address[1].trim());
            location.setState(address[2].trim());
            location.setPostcode(address[3].trim());
            location.setCountry(address[4].trim());
            user.setLocation(location);
            users.add(user);
        }
        u = userList2.lines().toList();
        for (String it : u) {
            String[] parts = it.split("\\|");
            HRUser user = new HRUser();
            HRUser.Name name = new HRUser.Name();
            name.setFirst(parts[3].trim());
            name.setLast(parts[4].trim());
            name.setTitle(parts[5].trim());
            user.setName(name);
            user.setEmail(parts[2].trim());
            HRUser.Location location = new HRUser.Location();
            String[] address = parts[1].trim().split(",");
            HRUser.Street street = new HRUser.Street();
            street.setNumber(Integer.parseInt(address[0].trim().split(" ")[0].trim()));
            street.setName(address[0].trim().substring(address[0].trim().indexOf(" ")).trim());
            location.setStreet(street);
            location.setCity(address[1].trim());
            location.setState(address[2].trim());
            location.setPostcode(address[3].trim());
            location.setCountry(address[4].trim());
            user.setLocation(location);
            users.add(user);
        }
        u = userList3.lines().toList();
        for (String it : u) {
            String[] parts = it.split("\\|");
            HRUser user = new HRUser();
            HRUser.Name name = new HRUser.Name();
            name.setFirst(parts[3].trim());
            name.setLast(parts[4].trim());
            name.setTitle(parts[5].trim());
            user.setName(name);
            user.setEmail(parts[2].trim());
            HRUser.Location location = new HRUser.Location();
            String[] address = parts[1].trim().split(",");
            HRUser.Street street = new HRUser.Street();
            street.setNumber(Integer.parseInt(address[0].trim().split(" ")[0].trim()));
            street.setName(address[0].trim().substring(address[0].trim().indexOf(" ")).trim());
            location.setStreet(street);
            location.setCity(address[1].trim());
            location.setState(address[2].trim());
            location.setPostcode(address[3].trim());
            location.setCountry(address[4].trim());
            user.setLocation(location);
            users.add(user);
        }
        u = userList4.lines().toList();
        for (String it : u) {
            String[] parts = it.split("\\|");
            HRUser user = new HRUser();
            HRUser.Name name = new HRUser.Name();
            name.setFirst(parts[3].trim());
            name.setLast(parts[4].trim());
            name.setTitle(parts[5].trim());
            user.setName(name);
            user.setEmail(parts[2].trim());
            HRUser.Location location = new HRUser.Location();
            String[] address = parts[1].trim().split(",");
            HRUser.Street street = new HRUser.Street();
            street.setNumber(Integer.parseInt(address[0].trim().split(" ")[0].trim()));
            street.setName(address[0].trim().substring(address[0].trim().indexOf(" ")).trim());
            location.setStreet(street);
            location.setCity(address[1].trim());
            location.setState(address[2].trim());
            location.setPostcode(address[3].trim());
            location.setCountry(address[4].trim());
            user.setLocation(location);
            users.add(user);
        }
        u = userList5.lines().toList();
        for (String it : u) {
            String[] parts = it.split("\\|");
            HRUser user = new HRUser();
            HRUser.Name name = new HRUser.Name();
            name.setFirst(parts[3].trim());
            name.setLast(parts[4].trim());
            name.setTitle(parts[5].trim());
            user.setName(name);
            user.setEmail(parts[2].trim());
            HRUser.Location location = new HRUser.Location();
            String[] address = parts[1].trim().split(",");
            HRUser.Street street = new HRUser.Street();
            street.setNumber(Integer.parseInt(address[0].trim().split(" ")[0].trim()));
            street.setName(address[0].trim().substring(address[0].trim().indexOf(" ")).trim());
            location.setStreet(street);
            location.setCity(address[1].trim());
            location.setState(address[2].trim());
            location.setPostcode(address[3].trim());
            location.setCountry(address[4].trim());
            user.setLocation(location);
            users.add(user);
        }
        u = userList6.lines().toList();
        for (String it : u) {
            String[] parts = it.split("\\|");
            HRUser user = new HRUser();
            HRUser.Name name = new HRUser.Name();
            name.setFirst(parts[3].trim());
            name.setLast(parts[4].trim());
            name.setTitle(parts[5].trim());
            user.setName(name);
            user.setEmail(parts[2].trim());
            HRUser.Location location = new HRUser.Location();
            String[] address = parts[1].trim().split(",");
            HRUser.Street street = new HRUser.Street();
            street.setNumber(Integer.parseInt(address[0].trim().split(" ")[0].trim()));
            street.setName(address[0].trim().substring(address[0].trim().indexOf(" ")).trim());
            location.setStreet(street);
            location.setCity(address[1].trim());
            location.setState(address[2].trim());
            location.setPostcode(address[3].trim());
            location.setCountry(address[4].trim());
            user.setLocation(location);
            users.add(user);
        }
    }

    public HRUserList get100() {
        HRUserList list = new HRUserList();
        for (int i = 0; i < 100; i++) {
            list.setResults(users.subList(0, 99));
        }
        lastUsed = 99;
        return list;
    }

    public User getNext() {
        lastUsed++;
        return users.get(lastUsed).toUser();
    }


    private String userList1 = """
            |   1 | 5616 Dogwood Ave, Bunbury, Western Australia, 4509, Australia                            | diane.collins@example.com         | Diane       | Collins       | Ms    |
            |   2 | 9948 New Street, Portmarnock, Tipperary, 90745, Ireland                                  | fiona.may@example.com             | Fiona       | May           | Ms    |
            |   3 | 2826 Windsor Road, Canterbury, Borders, W54 5LN, United Kingdom                          | angela.owens@example.com          | Angela      | Owens         | Miss  |
            |   4 | 5858 Manor Road, Dundee, Surrey, Z62 5ZL, United Kingdom                                 | catherine.ray@example.com         | Catherine   | Ray           | Ms    |
            |   5 | 7764 Karen Dr, Traralgon, Queensland, 5084, Australia                                    | veronica.fields@example.com       | Veronica    | Fields        | Miss  |
            |   6 | 6547 Highfield Road, Manchester, Leicestershire, KG5 5NJ, United Kingdom                 | christopher.hamilton@example.com  | Christopher | Hamilton      | Mr    |
            |   7 | 4984 York St, Summerside, New Brunswick, U2E 8O8, Canada                                 | laurie.wong@example.com           | Laurie      | Wong          | Mrs   |
            |   8 | 6436 Miller Ave, Wollongong, New South Wales, 494, Australia                             | colleen.harper@example.com        | Colleen     | Harper        | Ms    |
            |   9 | 3274 Karen Dr, Hampton, North Carolina, 68483, United States                             | annette.jones@example.com         | Annette     | Jones         | Mrs   |
            |  10 | 1369 W 6th St, Dubbo, Victoria, 8922, Australia                                          | peggy.barnett@example.com         | Peggy       | Barnett       | Ms    |
            |  11 | 1619 Church Road, City of London, Nottinghamshire, D3M 2HX, United Kingdom               | kate.mendoza@example.com          | Kate        | Mendoza       | Mrs   |
            |  12 | 755 North Road, Tullow, Limerick, 41419, Ireland                                         | lauren.odonoghue@example.com      | Lauren      | Odonoghue     | Ms    |
            |  13 | 8486 Herbert Road, Drogheda, Fingal, 75481, Ireland                                      | kate.lawson@example.com           | Kate        | Lawson        | Ms    |
            |  14 | 7928 Lone Wolf Trail, Davenport, Hawaii, 39734, United States                            | alex.mitchelle@example.com        | Alex        | Mitchelle     | Mr    |
            |  15 | 7559 Lake of Bays Road, New Glasgow, Newfoundland and Labrador, E4K 5V8, Canada          | adam.miller@example.com           | Adam        | Miller        | Mr    |
            |  16 | 8506 Pockrus Page Rd, Perth, New South Wales, 6394, Australia                            | ana.gardner@example.com           | Ana         | Gardner       | Ms    |
            |  17 | 2474 Railroad St, Adelaide, New South Wales, 1214, Australia                             | penny.morgan@example.com          | Penny       | Morgan        | Ms    |
            |  18 | 1486 Westmoreland Street, Carrick-on-Suir, Cork, 46947, Ireland                          | allie.dunne@example.com           | Allie       | Dunne         | Ms    |
            |  19 | 3667 Kings Road, City of London, Highlands and Islands, S0V 8QJ, United Kingdom          | lonnie.hart@example.com           | Lonnie      | Hart          | Mr    |
            |  20 | 7954 Lovers Ln, Toowoomba, New South Wales, 2917, Australia                              | jennifer.watkins@example.com      | Jennifer    | Watkins       | Mrs   |
            |  21 | 2287 Lone Wolf Trail, Miami, Oregon, 84617, United States                                | clyde.harper@example.com          | Clyde       | Harper        | Mr    |
            |  22 | 4849 Church Road, Bandon, Laois, 77073, Ireland                                          | holly.doyle@example.com           | Holly       | Doyle         | Mrs   |
            |  23 | 8632 Park Lane, Truro, County Fermanagh, B9D 9HH, United Kingdom                         | debbie.burke@example.com          | Debbie      | Burke         | Miss  |
            |  24 | 2595 Victoria Road, Athlone, Cavan, 40246, Ireland                                       | gerry.walker@example.com          | Gerry       | Walker        | Mr    |
            |  25 | 6492 22nd Ave, Borden, Nova Scotia, F2Z 1M6, Canada                                      | charlotte.mitchell@example.com    | Charlotte   | Mitchell      | Miss  |
            |  26 | 4334 Patrick Street, Monaghan, Fingal, 51172, Ireland                                    | ricky.gibson@example.com          | Ricky       | Gibson        | Mr    |
            |  27 | 9519 West Ave, Deer Lake, Nunavut, J8M 7Q1, Canada                                       | lily.barnaby@example.com          | Lily        | Barnaby       | Miss  |
            |  28 | 7632 Main Street, Nottingham, Tyne and Wear, TF8U 6WY, United Kingdom                    | holly.barrett@example.com         | Holly       | Barrett       | Mrs   |
            |  29 | 3849 Nowlin Rd, Baltimore, Wisconsin, 70288, United States                               | gabriella.beck@example.com        | Gabriella   | Beck          | Miss  |
            |  30 | 5407 Jones Road, Portarlington, Kerry, 96826, Ireland                                    | david.reynolds@example.com        | David       | Reynolds      | Mr    |
            |  31 | 3062 Grove Road, Athlone, South Dublin, 14803, Ireland                                   | gary.byrd@example.com             | Gary        | Byrd          | Mr    |
            |  32 | 4766 Royal Ln, Springfield, Pennsylvania, 19678, United States                           | darrell.tucker@example.com        | Darrell     | Tucker        | Mr    |
            |  33 | 6906 Poplar Dr, Bunbury, Northern Territory, 7146, Australia                             | louis.lambert@example.com         | Louis       | Lambert       | Mr    |
            |  34 | 8206 Cackson St, Detroit, Maine, 18093, United States                                    | julio.brooks@example.com          | Julio       | Brooks        | Mr    |
            |  35 | 731 Cedar St, Waterloo, Northwest Territories, Z0X 8K8, Canada                           | jack.mitchell@example.com         | Jack        | Mitchell      | Mr    |
            |  36 | 9100 Depaul Dr, Coffs Harbour, Queensland, 7513, Australia                               | darrell.hunt@example.com          | Darrell     | Hunt          | Mr    |
            |  37 | 2854 Victoria Street, Lichfield, Cheshire, OS5V 0RY, United Kingdom                      | jenny.hernandez@example.com       | Jenny       | Hernandez     | Miss  |
            |  38 | 33 Fairview St, Ballarat, Tasmania, 3834, Australia                                      | morris.richards@example.com       | Morris      | Richards      | Mr    |
            |  39 | 924 Mill Lane, Tramore, Donegal, 48712, Ireland                                          | katie.hamilton@example.com        | Katie       | Hamilton      | Miss  |
            |  40 | 6507 Nowlin Rd, Bathurst, Western Australia, 8551, Australia                             | sean.gutierrez@example.com        | Sean        | Gutierrez     | Mr    |
            |  41 | 4359 Eason Rd, Townsville, Australian Capital Territory, 6082, Australia                 | douglas.woods@example.com         | Douglas     | Woods         | Mr    |
            |  42 | 6643 Highfield Road, Athlone, Mayo, 24055, Ireland                                       | ellen.fletcher@example.com        | Ellen       | Fletcher      | Miss  |
            |  43 | 4919 Blossom Hill Rd, Red Bluff, Rhode Island, 65759, United States                      | ramona.kennedy@example.com        | Ramona      | Kennedy       | Mrs   |
            |  44 | 2499 Grand Ave, Belmont, Ontario, S5I 8F4, Canada                                        | noah.smith@example.com            | Noah        | Smith         | Mr    |
            |  45 | 311 Cackson St, Kalgoorlie, South Australia, 7445, Australia                             | gabriel.lynch@example.com         | Gabriel     | Lynch         | Mr    |
            |  46 | 7533 Patrick Street, Newbridge, Cork City, 42494, Ireland                                | heather.nelson@example.com        | Heather     | Nelson        | Ms    |
            |  47 | 9820 North Road, Limerick, Kerry, 11390, Ireland                                         | karl.fuller@example.com           | Karl        | Fuller        | Mr    |
            |  48 | 7085 Kings Road, Salford, Merseyside, R09 6GN, United Kingdom                            | brittany.carr@example.com         | Brittany    | Carr          | Mrs   |
            |  49 | 4565 Brown Terrace, Mildura, New South Wales, 8725, Australia                            | ethel.wilson@example.com          | Ethel       | Wilson        | Miss  |
            |  50 | 9738 Park Avenue, Bangor, Mid Glamorgan, DJ25 6GL, United Kingdom                        | scarlett.ford@example.com         | Scarlett    | Ford          | Mrs   |
            """;
    private String userList2 = """
            |  51 | 2157 Dundas Rd, Keswick, Québec, A3B 2M9, Canada                                         | theo.taylor@example.com           | Theo        | Taylor        | Mr    |
            |  52 | 1953 Valwood Pkwy, Nowra, New South Wales, 9728, Australia                               | serenity.fuller@example.com       | Serenity    | Fuller        | Mrs   |
            |  53 | 6320 Parliament St, Stirling, New Brunswick, O7Y 7V4, Canada                             | lea.white@example.com             | Lea         | White         | Miss  |
            |  54 | 8560 Grafton Street, Kells, Fingal, 51100, Ireland                                       | ethan.berry@example.com           | Ethan       | Berry         | Mr    |
            |  55 | 3558 Main St, Woodstock, New Brunswick, C1J 2I0, Canada                                  | alice.chow@example.com            | Alice       | Chow          | Mrs   |
            |  56 | 5335 Tecumseh Rd, Port Elgin, Northwest Territories, E3F 6D4, Canada                     | arnaud.liu@example.com            | Arnaud      | Liu           | Mr    |
            |  57 | 8624 Park Road, Leeds, Clwyd, J60 1LT, United Kingdom                                    | leroy.henderson@example.com       | Leroy       | Henderson     | Mr    |
            |  58 | 671 Spring St, Norman, Washington, 78022, United States                                  | allan.graham@example.com          | Allan       | Graham        | Mr    |
            |  59 | 1545 York St, Jasper, Yukon, K1C 5V7, Canada                                             | lucas.wilson@example.com          | Lucas       | Wilson        | Mr    |
            |  60 | 733 Lakeview Ave, Fauquier, Yukon, U8Y 2K6, Canada                                       | rose.morin@example.com            | Rose        | Morin         | Mrs   |
            |  61 | 7237 Oak St, Carleton, Québec, I2E 1D2, Canada                                           | anthony.kowalski@example.com      | Anthony     | Kowalski      | Mr    |
            |  62 | 4069 Westmoreland Street, Clonmel, Wicklow, 36283, Ireland                               | barb.carpenter@example.com        | Barb        | Carpenter     | Mrs   |
            |  63 | 4668 Fairview Road, Londonderry, Lothian, X5 6LW, United Kingdom                         | catherine.barrett@example.com     | Catherine   | Barrett       | Mrs   |
            |  64 | 132 Bridge Road, Exeter, Durham, E2 8JQ, United Kingdom                                  | ellie.curtis@example.com          | Ellie       | Curtis        | Ms    |
            |  65 | 1731 Mcgowen St, Bundaberg, Queensland, 5505, Australia                                  | jose.cruz@example.com             | Jose        | Cruz          | Mr    |
            |  66 | 9876 Highfield Road, Cashel, Limerick, 17163, Ireland                                    | susan.bates@example.com           | Susan       | Bates         | Miss  |
            |  67 | 5855 South Street, Cobh, Sligo, 94948, Ireland                                           | amber.bates@example.com           | Amber       | Bates         | Mrs   |
            |  68 | 2703 Brock Rd, Armstrong, Northwest Territories, B1I 3X6, Canada                         | maeva.bergeron@example.com        | Maeva       | Bergeron      | Mrs   |
            |  69 | 883 Argyle St, Aylmer, Québec, K6M 2C3, Canada                                           | xavier.ginnish@example.com        | Xavier      | Ginnish       | Mr    |
            |  70 | 2030 Charles St, Vanier, Nunavut, J4E 9Q1, Canada                                        | james.tremblay@example.com        | James       | Tremblay      | Mr    |
            |  71 | 4428 N Stelling Rd, Richardson, Delaware, 99974, United States                           | manuel.castro@example.com         | Manuel      | Castro        | Mr    |
            |  72 | 4032 Elgin St, Bunbury, Victoria, 9803, Australia                                        | margie.brewer@example.com         | Margie      | Brewer        | Ms    |
            |  73 | 6718 Manchester Road, Southampton, Worcestershire, W8P 5AE, United Kingdom               | alan.martin@example.com           | Alan        | Martin        | Mr    |
            |  74 | 486 Mill Road, Dundee, Lancashire, Y54 2QY, United Kingdom                               | anna.harris@example.com           | Anna        | Harris        | Ms    |
            |  75 | 5924 Ash Dr, Westminster, Montana, 11996, United States                                  | zoey.peters@example.com           | Zoey        | Peters        | Ms    |
            |  76 | 5645 Cedar St, Chatham, British Columbia, U9P 4A0, Canada                                | owen.bouchard@example.com         | Owen        | Bouchard      | Mr    |
            |  77 | 3868 Ash Dr, Fontana, Massachusetts, 37159, United States                                | frances.bowman@example.com        | Frances     | Bowman        | Mrs   |
            |  78 | 8731 Robinson Rd, Worcester, Vermont, 69430, United States                               | sean.bates@example.com            | Sean        | Bates         | Mr    |
            |  79 | 5447 Lakeview St, Bathurst, New South Wales, 6147, Australia                             | maureen.davidson@example.com      | Maureen     | Davidson      | Miss  |
            |  80 | 720 Highfield Road, Carrick-on-Shannon, Longford, 67974, Ireland                         | jimmie.simmmons@example.com       | Jimmie      | Simmmons      | Mr    |
            |  81 | 5596 W Belt Line Rd, Toowoomba, Western Australia, 1030, Australia                       | christopher.myers@example.com     | Christopher | Myers         | Mr    |
            |  82 | 827 Green Rd, Thornton, Oregon, 33182, United States                                     | tyler.carpenter@example.com       | Tyler       | Carpenter     | Mr    |
            |  83 | 9772 Victoria Road, Bath, West Midlands, W0 0GS, United Kingdom                          | lucy.romero@example.com           | Lucy        | Romero        | Miss  |
            |  84 | 1781 Brown Terrace, Nampa, Florida, 20886, United States                                 | gregory.jackson@example.com       | Gregory     | Jackson       | Mr    |
            |  85 | 7173 Queen St, Southampton, New Brunswick, K9T 2H6, Canada                               | maya.cote@example.com             | Maya        | Côté          | Ms    |
            |  86 | 2777 Maple Ave, Clinton, Yukon, F3R 3M9, Canada                                          | isabella.li@example.com           | Isabella    | Li            | Mrs   |
            |  87 | 7216 The Drive, Carrigaline, Mayo, 60120, Ireland                                        | grace.beck@example.com            | Grace       | Beck          | Mrs   |
            |  88 | 1866 W Gray St, College Station, Kentucky, 64996, United States                          | lori.mitchelle@example.com        | Lori        | Mitchelle     | Miss  |
            |  89 | 116 Dame Street, Thurles, Mayo, 53710, Ireland                                           | sam.chambers@example.com          | Sam         | Chambers      | Mr    |
            |  90 | 828 Central St, Queanbeyan, Northern Territory, 3407, Australia                          | kyle.horton@example.com           | Kyle        | Horton        | Mr    |
            |  91 | 2691 School Lane, St Albans, Somerset, I55 1JB, United Kingdom                           | ian.stanley@example.com           | Ian         | Stanley       | Mr    |
            |  92 | 1731 N Stelling Rd, Orlando, Delaware, 98110, United States                              | miriam.jordan@example.com         | Miriam      | Jordan        | Mrs   |
            |  93 | 6279 Frederick Ave, Maitland, Québec, D3K 8F7, Canada                                    | ryan.white@example.com            | Ryan        | White         | Mr    |
            |  94 | 4112 Marsh Ln, Launceston, Northern Territory, 8349, Australia                           | irma.hanson@example.com           | Irma        | Hanson        | Mrs   |
            |  95 | 4123 Vimy St, Delisle, Québec, X5Z 1H7, Canada                                           | noemie.taylor@example.com         | Noémie      | Taylor        | Ms    |
            |  96 | 1124 Chester Road, Worcester, Leicestershire, C8 6HX, United Kingdom                     | kelly.pearson@example.com         | Kelly       | Pearson       | Ms    |
            |  97 | 3572 School Lane, Listowel, Waterford, 26778, Ireland                                    | eleanor.bailey@example.com        | Eleanor     | Bailey        | Miss  |
            |  98 | 1201 The Green, Naas, Tipperary, 16122, Ireland                                          | sophia.williamson@example.com     | Sophia      | Williamson    | Mrs   |
            |  99 | 446 Daisy Dr, Brisbane, Tasmania, 6684, Australia                                        | darryl.stewart@example.com        | Darryl      | Stewart       | Mr    |
            | 100 | 496 Prospect Rd, Perth, Western Australia, 2409, Australia                               | rachel.andrews@example.com        | Rachel      | Andrews       | Ms    |
            """;

    private String userList3 = """
            | 101 | 6581 Paddock Way, Murrieta, Nebraska, 43901, United States                               | myrtle.riley@example.com          | Myrtle      | Riley         | Miss  |
            | 102 | 6856 E Center St, Van Alstyne, South Carolina, 42166, United States                      | vera.sutton@example.com           | Vera        | Sutton        | Miss  |
            | 103 | 9928 Hogan St, Port Macquarie, New South Wales, 540, Australia                           | rita.banks@example.com            | Rita        | Banks         | Mrs   |
            | 104 | 6964 Patrick Street, Birr, Meath, 55077, Ireland                                         | susanne.wilson@example.com        | Susanne     | Wilson        | Mrs   |
            | 105 | 9945 E Pecan St, Corpus Christi, Colorado, 79410, United States                          | brent.robertson@example.com       | Brent       | Robertson     | Mr    |
            | 106 | 5281 Ranchview Dr, Cairns, Victoria, 1172, Australia                                     | jerry.simpson@example.com         | Jerry       | Simpson       | Mr    |
            | 107 | 5713 Blossom Hill Rd, Surrey, Oregon, 57051, United States                               | bobbie.wade@example.com           | Bobbie      | Wade          | Ms    |
            | 108 | 5265 Richmond Road, Truro, County Armagh, J8 3HY, United Kingdom                         | tommy.hamilton@example.com        | Tommy       | Hamilton      | Mr    |
            | 109 | 2252 Sunset St, Steilacoom, Arizona, 29222, United States                                | morris.king@example.com           | Morris      | King          | Mr    |
            | 110 | 7432 Dieppe Ave, Notre Dame de Lourdes, Manitoba, F2T 1C6, Canada                        | jasmine.kowalski@example.com      | Jasmine     | Kowalski      | Miss  |
            | 111 | 9933 The Drive, Tipperary, Longford, 12357, Ireland                                      | emily.allen@example.com           | Emily       | Allen         | Mrs   |
            | 112 | 9013 Spring St, Ann Arbor, Pennsylvania, 56911, United States                            | renee.harvey@example.com          | Renee       | Harvey        | Mrs   |
            | 113 | 5963 School Lane, Wolverhampton, County Fermanagh, TQ9 6SL, United Kingdom               | zander.fernandez@example.com      | Zander      | Fernandez     | Mr    |
            | 114 | 9228 Dublin Road, Killarney, Kerry, 80842, Ireland                                       | linda.porter@example.com          | Linda       | Porter        | Ms    |
            | 115 | 2994 Depaul Dr, Tamworth, Northern Territory, 3366, Australia                            | hazel.robertson@example.com       | Hazel       | Robertson     | Miss  |
            | 116 | 8762 Station Road, Ardee, Monaghan, 32257, Ireland                                       | anna.carlson@example.com          | Anna        | Carlson       | Mrs   |
            | 117 | 5154 Mill Lane, Gorey, Galway, 96634, Ireland                                            | maria.banks@example.com           | Maria       | Banks         | Ms    |
            | 118 | 732 Blossom Hill Rd, Roanoke, Illinois, 99138, United States                             | misty.woods@example.com           | Misty       | Woods         | Miss  |
            | 119 | 164 Cherry St, Orange, Australian Capital Territory, 706, Australia                      | marion.stone@example.com          | Marion      | Stone         | Mr    |
            | 120 | 5331 Dogwood Ave, Tamworth, Australian Capital Territory, 6995, Australia                | david.davidson@example.com        | David       | Davidson      | Mr    |
            | 121 | 487 Grange Road, Aberdeen, County Londonderry, DG46 5YA, United Kingdom                  | leah.garza@example.com            | Leah        | Garza         | Mrs   |
            | 122 | 2539 Edwards Rd, Roseburg, Maine, 65864, United States                                   | brayden.bates@example.com         | Brayden     | Bates         | Mr    |
            | 123 | 5305 High Street, Chester, Lincolnshire, UL9A 3BW, United Kingdom                        | sophia.cole@example.com           | Sophia      | Cole          | Miss  |
            | 124 | 9099 White Oak Dr, Queanbeyan, Queensland, 4518, Australia                               | bill.berry@example.com            | Bill        | Berry         | Mr    |
            | 125 | 3704 Plum St, Pompano Beach, Illinois, 13557, United States                              | cecil.martin@example.com          | Cecil       | Martin        | Mr    |
            | 126 | 5323 Church Road, Bray, Wexford, 10918, Ireland                                          | jimmie.griffin@example.com        | Jimmie      | Griffin       | Mr    |
            | 127 | 4909 West Street, Leeds, Cumbria, Q80 7FP, United Kingdom                                | gabe.bowman@example.com           | Gabe        | Bowman        | Mr    |
            | 128 | 7041 Patrick Street, Buncrana, Kerry, 28226, Ireland                                     | derek.osullivan@example.com       | Derek       | Osullivan     | Mr    |
            | 129 | 3457 Central St, Rockhampton, Queensland, 4255, Australia                                | felecia.fisher@example.com        | Felecia     | Fisher        | Mrs   |
            | 130 | 2137 Killarney Road, Swords, Kerry, 24978, Ireland                                       | enrique.bates@example.com         | Enrique     | Bates         | Mr    |
            | 131 | 7554 Victoria Road, Bandon, Kilkenny, 12931, Ireland                                     | fiona.williamson@example.com      | Fiona       | Williamson    | Ms    |
            | 132 | 5733 W Belt Line Rd, Carlsbad, Nevada, 82543, United States                              | andrea.armstrong@example.com      | Andrea      | Armstrong     | Miss  |
            | 133 | 6125 London Road, Salford, County Down, W3U 6ZB, United Kingdom                          | willie.byrd@example.com           | Willie      | Byrd          | Mr    |
            | 134 | 8481 Rectory Lane, Nottingham, Merseyside, QT52 3RW, United Kingdom                      | jimmie.wallace@example.com        | Jimmie      | Wallace       | Mr    |
            | 135 | 4031 Pearse Street, Thurles, Dublin City, 24577, Ireland                                 | josef.wallace@example.com         | Josef       | Wallace       | Mr    |
            | 136 | 4762 The Crescent, Roscrea, South Dublin, 90263, Ireland                                 | hanna.hill@example.com            | Hanna       | Hill          | Mrs   |
            | 137 | 8895 20th Ave, Delisle, Ontario, D8X 4L1, Canada                                         | harper.walker@example.com         | Harper      | Walker        | Mrs   |
            | 138 | 1447 Green Lane, Peterborough, Bedfordshire, Z9 4LW, United Kingdom                      | katherine.bell@example.com        | Katherine   | Bell          | Miss  |
            | 139 | 5786 Homestead Rd, Kalgoorlie, Australian Capital Territory, 5196, Australia             | harry.armstrong@example.com       | Harry       | Armstrong     | Mr    |
            | 140 | 4797 The Green, Newport, Surrey, XM2E 5LP, United Kingdom                                | amanda.lee@example.com            | Amanda      | Lee           | Ms    |
            | 141 | 7823 Park Avenue, Oxford, Hertfordshire, R41 9BP, United Kingdom                         | vanessa.snyder@example.com        | Vanessa     | Snyder        | Ms    |
            | 142 | 9408 Samaritan Dr, Hollywood, Oklahoma, 37491, United States                             | howard.chambers@example.com       | Howard      | Chambers      | Mr    |
            | 143 | 7292 Church Street, Swords, Carlow, 39488, Ireland                                       | kaitlin.phillips@example.com      | Kaitlin     | Phillips      | Ms    |
            | 144 | 1389 Henry Street, Kinsealy-Drinan, South Dublin, 29988, Ireland                         | victoria.simpson@example.com      | Victoria    | Simpson       | Ms    |
            | 145 | 8157 Plum St, Traralgon, Tasmania, 4546, Australia                                       | juan.dixon@example.com            | Juan        | Dixon         | Mr    |
            | 146 | 1146 Railroad St, Mackay, Victoria, 8109, Australia                                      | leslie.jones@example.com          | Leslie      | Jones         | Mr    |
            | 147 | 6396 Queens Road, Norwich, Somerset, Q8O 0BQ, United Kingdom                             | kenneth.gibson@example.com        | Kenneth     | Gibson        | Mr    |
            | 148 | 1970 Forest Ln, Wagga Wagga, South Australia, 7741, Australia                            | myrtle.mcdonalid@example.com      | Myrtle      | Mcdonalid     | Miss  |
            | 149 | 7732 Dalhousie Ave, Stratford, New Brunswick, C5P 6R7, Canada                            | jasmine.novak@example.com         | Jasmine     | Novak         | Mrs   |
            | 150 | 949 Dieppe Ave, Sidney, Alberta, C0N 5P4, Canada                                         | jeanne.bouchard@example.com       | Jeanne      | Bouchard      | Mrs   |
            """;

    private String userList4 = """
            | 151 | 205 Galway Road, Dunboyne, Kilkenny, 46768, Ireland                                      | rick.hanson@example.com           | Rick        | Hanson        | Mr    |
            | 152 | 3785 Richmond Park, Cork, Dublin City, 51756, Ireland                                    | mathew.black@example.com          | Mathew      | Black         | Mr    |
            | 153 | 4992 Queen Street, Canterbury, Gloucestershire, HL1 5SG, United Kingdom                  | todd.davies@example.com           | Todd        | Davies        | Mr    |
            | 154 | 556 Fincher Rd, Bathurst, Victoria, 7558, Australia                                      | marshall.rogers@example.com       | Marshall    | Rogers        | Mr    |
            | 155 | 1005 Church Street, Celbridge, Offaly, 53180, Ireland                                    | ben.brewer@example.com            | Ben         | Brewer        | Mr    |
            | 156 | 6106 Frances Ct, Gainesville, Wisconsin, 32707, United States                            | darren.holt@example.com           | Darren      | Holt          | Mr    |
            | 157 | 2048 Nowlin Rd, Darwin, South Australia, 3758, Australia                                 | sergio.alexander@example.com      | Sergio      | Alexander     | Mr    |
            | 158 | 3630 9th St, Field, Nunavut, M0F 4Q0, Canada                                             | owen.margaret@example.com         | Owen        | Margaret      | Mr    |
            | 159 | 6105 Cork Street, Dunboyne, Meath, 62144, Ireland                                        | barb.holland@example.com          | Barb        | Holland       | Miss  |
            | 160 | 5208 Brock Rd, Sherbrooke, Northwest Territories, J4N 3V1, Canada                        | aubrey.mitchell@example.com       | Aubrey      | Mitchell      | Ms    |
            | 161 | 3227 Dundas Rd, Killarney, Saskatchewan, T2E 6M6, Canada                                 | charles.miller@example.com        | Charles     | Miller        | Mr    |
            | 162 | 2600 Spring St, Tallahassee, Kansas, 57675, United States                                | sean.ford@example.com             | Sean        | Ford          | Mr    |
            | 163 | 7559 3rd St, Brockton, Prince Edward Island, P4V 1R3, Canada                             | ella.anderson@example.com         | Ella        | Anderson      | Mrs   |
            | 164 | 1850 Dundas Rd, Aylmer, New Brunswick, R0C 5D4, Canada                                   | elliot.chu@example.com            | Elliot      | Chu           | Mr    |
            | 165 | 359 Simcoe St, Elgin, Ontario, T6M 8K3, Canada                                           | victor.martin@example.com         | Victor      | Martin        | Mr    |
            | 166 | 9053 22nd Ave, Westport, Saskatchewan, M5I 2F1, Canada                                   | ella.macdonald@example.com        | Ella        | Macdonald     | Mrs   |
            | 167 | 4224 Richmond Road, Leeds, Dumfries and Galloway, CH6 8UQ, United Kingdom                | maddison.ferguson@example.com     | Maddison    | Ferguson      | Ms    |
            | 168 | 1698 Queensway, Winchester, Cleveland, BZ8G 1GE, United Kingdom                          | clayton.garcia@example.com        | Clayton     | Garcia        | Mr    |
            | 169 | 8633 Fincher Rd, Kalgoorlie, Tasmania, 1555, Australia                                   | celina.butler@example.com         | Celina      | Butler        | Mrs   |
            | 170 | 4374 W 6th St, Adelaide, Australian Capital Territory, 1422, Australia                   | nina.pena@example.com             | Nina        | Pena          | Miss  |
            | 171 | 3427 St. Lawrence Ave, New Glasgow, Nunavut, J5J 7I9, Canada                             | alexis.gauthier@example.com       | Alexis      | Gauthier      | Mrs   |
            | 172 | 4703 Ormond Quay, Naas, Galway City, 78728, Ireland                                      | clifford.jensen@example.com       | Clifford    | Jensen        | Mr    |
            | 173 | 6927 E Center St, Albany, New South Wales, 3429, Australia                               | krin.carlson@example.com          | Krin        | Carlson       | Mrs   |
            | 174 | 9675 The Grove, Castlebar, Carlow, 60311, Ireland                                        | stephanie.gordon@example.com      | Stephanie   | Gordon        | Ms    |
            | 175 | 6434 Killarney Road, Galway, Sligo, 24105, Ireland                                       | suzy.gilbert@example.com          | Suzy        | Gilbert       | Ms    |
            | 176 | 3234 Dufferin St, Windsor, Northwest Territories, P8P 8O8, Canada                        | jeanne.knight@example.com         | Jeanne      | Knight        | Ms    |
            | 177 | 6422 Springfield Road, Newport, Norfolk, P8A 9HG, United Kingdom                         | brittany.simmmons@example.com     | Brittany    | Simmmons      | Ms    |
            | 178 | 3961 Killarney Road, Waterford, Galway City, 27745, Ireland                              | maddison.russell@example.com      | Maddison    | Russell       | Ms    |
            | 179 | 8130 Main Street, Thurles, Dublin City, 39058, Ireland                                   | gregory.lucas@example.com         | Gregory     | Lucas         | Mr    |
            | 180 | 9085 Bollinger Rd, Adelaide, Victoria, 3613, Australia                                   | karl.lynch@example.com            | Karl        | Lynch         | Mr    |
            | 181 | 1958 9th St, Cornwall, Alberta, I7N 3T3, Canada                                          | jack.bouchard@example.com         | Jack        | Bouchard      | Mr    |
            | 182 | 3176 Park Avenue, Sheffield, Rutland, I4 9RU, United Kingdom                             | angela.cooper@example.com         | Angela      | Cooper        | Mrs   |
            | 183 | 3616 Main Road, Gloucester, Lancashire, NX6N 9LS, United Kingdom                         | lily.sims@example.com             | Lily        | Sims          | Miss  |
            | 184 | 7525 Cackson St, Plano, Nebraska, 56632, United States                                   | marian.bryant@example.com         | Marian      | Bryant        | Ms    |
            | 185 | 9872 Alexander Road, Maynooth, Monaghan, 62673, Ireland                                  | luis.kelly@example.com            | Luis        | Kelly         | Mr    |
            | 186 | 1357 Park Road, Bangor, County Londonderry, XY1O 7WT, United Kingdom                     | emily.griffin@example.com         | Emily       | Griffin       | Ms    |
            | 187 | 2720 School Lane, Galway, South Dublin, 39330, Ireland                                   | herbert.pierce@example.com        | Herbert     | Pierce        | Mr    |
            | 188 | 7800 High Street, Durham, Greater Manchester, OD18 3SE, United Kingdom                   | roberto.jones@example.com         | Roberto     | Jones         | Mr    |
            | 189 | 9193 Mockingbird Hill, Cedar Hill, Massachusetts, 60871, United States                   | florence.tucker@example.com       | Florence    | Tucker        | Ms    |
            | 190 | 9021 Grafton Street, Longford, Cork City, 96682, Ireland                                 | donna.wells@example.com           | Donna       | Wells         | Miss  |
            | 191 | 5662 W Campbell Ave, Devonport, South Australia, 2774, Australia                         | vera.cox@example.com              | Vera        | Cox           | Miss  |
            | 192 | 3156 Nowlin Rd, Queanbeyan, South Australia, 4397, Australia                             | erica.long@example.com            | Erica       | Long          | Miss  |
            | 193 | 8029 North Road, Kildare, Sligo, 79886, Ireland                                          | martha.fitzgerald@example.com     | Martha      | Fitzgerald    | Ms    |
            | 194 | 5250 Dieppe Ave, Cornwall, Prince Edward Island, W2U 1P5, Canada                         | julia.anderson@example.com        | Julia       | Anderson      | Miss  |
            | 195 | 1126 Paddock Way, Coffs Harbour, South Australia, 9227, Australia                        | bruce.russell@example.com         | Bruce       | Russell       | Mr    |
            | 196 | 6611 Marsh Ln, Boulder, Pennsylvania, 27263, United States                               | anne.douglas@example.com          | Anne        | Douglas       | Miss  |
            | 197 | 1126 Concession Road 6, Westport, Newfoundland and Labrador, G5F 8M6, Canada             | logan.gill@example.com            | Logan       | Gill          | Mr    |
            | 198 | 825 Albert Road, Duleek, Carlow, 94377, Ireland                                          | caitlin.cox@example.com           | Caitlin     | Cox           | Miss  |
            | 199 | 9740 Main Street, Newport, Buckinghamshire, T34 8QZ, United Kingdom                      | barbara.holmes@example.com        | Barbara     | Holmes        | Ms    |
            | 200 | 7586 Central St, Bathurst, New South Wales, 7234, Australia                              | dale.hamilton@example.com         | Dale        | Hamilton      | Mr    |
            """;
    private String userList5 = """
            | 201 | 4917 Jones Road, Fermoy, Waterford, 62115, Ireland                                       | gerry.meyer@example.com           | Gerry       | Meyer         | Mr    |
            | 202 | 92 School Lane, Westminster, Fife, O9 6DX, United Kingdom                                | carol.simmons@example.com         | Carol       | Simmons       | Ms    |
            | 203 | 4999 Camden Ave, Warrnambool, South Australia, 517, Australia                            | rafael.butler@example.com         | Rafael      | Butler        | Mr    |
            | 204 | 6306 Albert Road, Newport, Cleveland, UD73 9JU, United Kingdom                           | brennan.black@example.com         | Brennan     | Black         | Mr    |
            | 205 | 1071 Park Lane, Ashbourne, Wexford, 55509, Ireland                                       | gerald.hamilton@example.com       | Gerald      | Hamilton      | Mr    |
            | 206 | 7026 Blossom Hill Rd, Tucson, Pennsylvania, 85503, United States                         | ron.davis@example.com             | Ron         | Davis         | Mr    |
            | 207 | 7367 Church Lane, Bristol, Leicestershire, C7 2DQ, United Kingdom                        | sara.williamson@example.com       | Sara        | Williamson    | Ms    |
            | 208 | 5427 Lovers Ln, Yonkers, Montana, 12364, United States                                   | catherine.jimenez@example.com     | Catherine   | Jimenez       | Mrs   |
            | 209 | 7752 Nowlin Rd, Port St. Lucie, Maryland, 32188, United States                           | lynn.thomas@example.com           | Lynn        | Thomas        | Mrs   |
            | 210 | 8157 36th Ave, Inverness, Saskatchewan, T7S 9V0, Canada                                  | nathan.macdonald@example.com      | Nathan      | Macdonald     | Mr    |
            | 211 | 410 Green Lane, Lichfield, Gwynedd County, B44 4WH, United Kingdom                       | avery.perkins@example.com         | Avery       | Perkins       | Miss  |
            | 212 | 7527 W Campbell Ave, Warragul, Victoria, 1207, Australia                                 | freddie.robinson@example.com      | Freddie     | Robinson      | Mr    |
            | 213 | 9685 The Drive, Brighton and Hove, Kent, QW70 6PS, United Kingdom                        | jordan.wheeler@example.com        | Jordan      | Wheeler       | Mr    |
            | 214 | 967 Dame Street, Thurles, Wicklow, 86273, Ireland                                        | kurt.williams@example.com         | Kurt        | Williams      | Mr    |
            | 215 | 6330 Kingsway, Wolverhampton, Cornwall, R2 3GL, United Kingdom                           | freddie.lucas@example.com         | Freddie     | Lucas         | Mr    |
            | 216 | 6289 Thornridge Cir, Akron, Wisconsin, 31612, United States                              | maxine.hicks@example.com          | Maxine      | Hicks         | Ms    |
            | 217 | 7863 Tara Street, Killarney, Dún Laoghaire–Rathdown, 50309, Ireland                      | mia.ferguson@example.com          | Mia         | Ferguson      | Ms    |
            | 218 | 2754 Maple Ave, Campbellton, Newfoundland and Labrador, W3H 5F3, Canada                  | lily.smith@example.com            | Lily        | Smith         | Ms    |
            | 219 | 7642 College St, Irving, New York, 82971, United States                                  | calvin.oliver@example.com         | Calvin      | Oliver        | Mr    |
            | 220 | 3001 Parker Rd, Fayetteville, New Hampshire, 41104, United States                        | layla.young@example.com           | Layla       | Young         | Miss  |
            | 221 | 611 Charles St, Waterloo, Yukon, I1G 7U7, Canada                                         | liam.patel@example.com            | Liam        | Patel         | Mr    |
            | 222 | 5822 Victoria Ave, Sandy Lake, Alberta, T6O 1J8, Canada                                  | maeva.sirko@example.com           | Maeva       | Sirko         | Ms    |
            | 223 | 1379 Saddle Dr, Geelong, Western Australia, 9028, Australia                              | willard.gregory@example.com       | Willard     | Gregory       | Mr    |
            | 224 | 8392 First Street, Columbus, West Virginia, 22379, United States                         | kathy.murray@example.com          | Kathy       | Murray        | Mrs   |
            | 225 | 1855 Kings Road, Aberdeen, Gwynedd County, VK6 7WY, United Kingdom                       | jar.rhodes@example.com            | Jar         | Rhodes        | Mr    |
            | 226 | 5524 O'Connell Avenue, Dublin, Louth, 82639, Ireland                                     | sara.hudson@example.com           | Sara        | Hudson        | Miss  |
            | 227 | 7139 Dogwood Ave, Ballarat, Northern Territory, 323, Australia                           | beverly.barnett@example.com       | Beverly     | Barnett       | Mrs   |
            | 228 | 8534 Killarney Road, Tuam, Fingal, 72617, Ireland                                        | carol.murphy@example.com          | Carol       | Murphy        | Mrs   |
            | 229 | 3611 Queens Road, Preston, Powys, K4 0TA, United Kingdom                                 | megan.jordan@example.com          | Megan       | Jordan        | Mrs   |
            | 230 | 5653 Concession Road 6, Russell, Nunavut, R9D 8C8, Canada                                | alicia.wong@example.com           | Alicia      | Wong          | Ms    |
            | 231 | 4265 School Lane, Enniscorthy, Sligo, 32879, Ireland                                     | lloyd.walters@example.com         | Lloyd       | Walters       | Mr    |
            | 232 | 4620 Samaritan Dr, Yonkers, Mississippi, 28256, United States                            | lois.carpenter@example.com        | Lois        | Carpenter     | Mrs   |
            | 233 | 941 Plum St, Las Cruces, Oregon, 98670, United States                                    | victor.fuller@example.com         | Victor      | Fuller        | Mr    |
            | 234 | 2515 Marsh Ln, Albuquerque, Nevada, 72599, United States                                 | christian.nguyen@example.com      | Christian   | Nguyen        | Mr    |
            | 235 | 3542 Church Lane, Newcastle upon Tyne, Highlands and Islands, H1E 0NP, United Kingdom    | sara.perry@example.com            | Sara        | Perry         | Ms    |
            | 236 | 9252 West Ave, Fountainbleu, Northwest Territories, R8Y 4O8, Canada                      | ryan.bergeron@example.com         | Ryan        | Bergeron      | Mr    |
            | 237 | 423 Valley View Ln, Anna, Ohio, 28529, United States                                     | hazel.gonzales@example.com        | Hazel       | Gonzales      | Miss  |
            | 238 | 5032 Grove Road, Liverpool, Oxfordshire, YI1V 9EN, United Kingdom                        | grace.davidson@example.com        | Grace       | Davidson      | Miss  |
            | 239 | 6926 Victoria Road, New Ross, Galway City, 10208, Ireland                                | bruce.fletcher@example.com        | Bruce       | Fletcher      | Mr    |
            | 240 | 3040 Hillcrest Rd, Hervey Bay, Northern Territory, 3213, Australia                       | bobbie.fernandez@example.com      | Bobbie      | Fernandez     | Mrs   |
            | 241 | 338 Hickory Creek Dr, Philadelphia, New Mexico, 78729, United States                     | darlene.williamson@example.com    | Darlene     | Williamson    | Miss  |
            | 242 | 6588 Westmoreland Street, Killarney, Mayo, 10932, Ireland                                | eleanor.mitchelle@example.com     | Eleanor     | Mitchelle     | Miss  |
            | 243 | 5087 Alexander Road, Carrickmacross, Kilkenny, 69108, Ireland                            | eli.meehan@example.com            | Eli         | Meehan        | Mr    |
            | 244 | 5339 Station Road, Norwich, Kent, IF1L 3SZ, United Kingdom                               | milton.pearson@example.com        | Milton      | Pearson       | Mr    |
            | 245 | 5769 Victoria Road, Duleek, Waterford, 74728, Ireland                                    | janet.lynch@example.com           | Janet       | Lynch         | Mrs   |
            | 246 | 5999 Locust Rd, Temecula, Vermont, 32087, United States                                  | leslie.spencer@example.com        | Leslie      | Spencer       | Mr    |
            | 247 | 6001 North Road, Birmingham, Durham, C0 6HD, United Kingdom                              | willard.franklin@example.com      | Willard     | Franklin      | Mr    |
            | 248 | 7874 Boghall Road, Roscommon, Cavan, 53573, Ireland                                      | elizabeth.kelley@example.com      | Elizabeth   | Kelley        | Miss  |
            | 249 | 8241 St. Lawrence Ave, Richmond, Manitoba, U6D 1B9, Canada                               | lily.chan@example.com             | Lily        | Chan          | Ms    |
            | 250 | 2815 Mcclellan Rd, Geraldton, South Australia, 8965, Australia                           | vivan.banks@example.com           | Vivan       | Banks         | Ms    |""";
    private String userList6 = """
            | 251 | 835 Rectory Lane, Gloucester, Lincolnshire, Y8Q 6YG, United Kingdom                      | sergio.george@example.com         | Sergio      | George        | Mr    |
            | 252 | 5139 Mockingbird Hill, Chandler, Nevada, 57359, United States                            | debra.clark@example.com           | Debra       | Clark         | Ms    |
            | 253 | 2047 Grange Road, Salisbury, Cumbria, NG42 4FJ, United Kingdom                           | abby.jensen@example.com           | Abby        | Jensen        | Mrs   |
            | 254 | 5818 St. John’S Road, Bradford, County Antrim, K5B 1BB, United Kingdom                   | dave.holt@example.com             | Dave        | Holt          | Mr    |
            | 255 | 3447 Dufferin St, Lasalle, Alberta, R5B 9X3, Canada                                      | benjamin.claire@example.com       | Benjamin    | Claire        | Mr    |
            | 256 | 6712 E Pecan St, Syracuse, Arizona, 28521, United States                                 | lois.reed@example.com             | Lois        | Reed          | Ms    |
            | 257 | 4473 Thornridge Cir, Bathurst, Western Australia, 6276, Australia                        | violet.morgan@example.com         | Violet      | Morgan        | Miss  |
            | 258 | 8563 Stanley Road, Sunderland, Kent, TU5 8RL, United Kingdom                             | greg.burns@example.com            | Greg        | Burns         | Mr    |
            | 259 | 3416 Grand Marais Ave, Cornwall, New Brunswick, A3Q 7K4, Canada                          | alexander.williams@example.com    | Alexander   | Williams      | Mr    |
            | 260 | 210 Main Road, Winchester, Bedfordshire, G8 6JA, United Kingdom                          | elmer.henry@example.com           | Elmer       | Henry         | Mr    |
            | 261 | 8503 Poplar Dr, South Bend, Ohio, 12342, United States                                   | samuel.robertson@example.com      | Samuel      | Robertson     | Mr    |
            | 262 | 5623 Dufferin St, Hampton, Manitoba, K4E 3D9, Canada                                     | oliver.morin@example.com          | Oliver      | Morin         | Mr    |
            | 263 | 8901 North Street, Birr, Galway, 37482, Ireland                                          | leah.hunter@example.com           | Leah        | Hunter        | Mrs   |
            | 264 | 8677 Main St, Oakville, Manitoba, Y2I 9M7, Canada                                        | maeva.roy@example.com             | Maeva       | Roy           | Ms    |
            | 265 | 632 Springfield Road, Ashbourne, Kilkenny, 33414, Ireland                                | abbey.reynolds@example.com        | Abbey       | Reynolds      | Mrs   |
            | 266 | 4647 Mockingbird Hill, Inglewood, Delaware, 46384, United States                         | marcus.herrera@example.com        | Marcus      | Herrera       | Mr    |
            | 267 | 4331 St. Catherine St, Notre Dame de Lourdes, Newfoundland and Labrador, X3I 0J8, Canada | alexis.knight@example.com         | Alexis      | Knight        | Ms    |
            | 268 | 5661 Hamilton Ave, Shepparton, Northern Territory, 9317, Australia                       | avery.jennings@example.com        | Avery       | Jennings      | Mrs   |
            | 269 | 2824 Station Road, Durham, Highlands and Islands, WC21 1RQ, United Kingdom               | patricia.ward@example.com         | Patricia    | Ward          | Mrs   |
            | 270 | 7492 E Center St, Mildura, Queensland, 8913, Australia                                   | dale.peters@example.com           | Dale        | Peters        | Mr    |
            | 271 | 8114 Daisy Dr, Tweed, Queensland, 2496, Australia                                        | jonathan.reynolds@example.com     | Jonathan    | Reynolds      | Mr    |
            | 272 | 1333 Wellington St, St. Antoine, Québec, M8G 4F9, Canada                                 | thomas.fortin@example.com         | Thomas      | Fortin        | Mr    |
            | 273 | 6507 Park Road, Liverpool, Dumfries and Galloway, F37 9FP, United Kingdom                | erik.wade@example.com             | Erik        | Wade          | Mr    |
            | 274 | 3986 Victoria Road, Preston, Wiltshire, CI1 9DE, United Kingdom                          | sarah.washington@example.com      | Sarah       | Washington    | Miss  |
            | 275 | 5994 Karen Dr, Wagga Wagga, Queensland, 2110, Australia                                  | bill.carlson@example.com          | Bill        | Carlson       | Mr    |
            | 276 | 8047 Parker Rd, Miramar, Missouri, 66698, United States                                  | steven.thompson@example.com       | Steven      | Thompson      | Mr    |
            | 277 | 5250 Coastal Highway, Cadillac, British Columbia, U5B 8Z4, Canada                        | logan.jean-baptiste@example.com   | Logan       | Jean-Baptiste | Mr    |
            | 278 | 8075 Fairview St, Great Falls, Montana, 44572, United States                             | sally.pierce@example.com          | Sally       | Pierce        | Mrs   |
            | 279 | 9609 Simcoe St, Southampton, Yukon, R9T 9E3, Canada                                      | emile.mitchell@example.com        | Emile       | Mitchell      | Mr    |
            | 280 | 1003 New Street, Ripon, Somerset, K36 7SL, United Kingdom                                | rebecca.sims@example.com          | Rebecca     | Sims          | Mrs   |
            | 281 | 7468 Bruce St, Joliet, Maine, 85784, United States                                       | kristin.elliott@example.com       | Kristin     | Elliott       | Miss  |
            | 282 | 9251 The Green, Edinburgh, West Glamorgan, EX7 7HY, United Kingdom                       | ernest.hunter@example.com         | Ernest      | Hunter        | Mr    |
            | 283 | 1714 Charles St, Wellington, Yukon, R4N 0O0, Canada                                      | oliver.lavigne@example.com        | Oliver      | Lavigne       | Mr    |
            | 284 | 8137 High Street, Winchester, Merseyside, Y1R 3DF, United Kingdom                        | tim.gonzalez@example.com          | Tim         | Gonzalez      | Mr    |
            | 285 | 9392 Dane St, Chicago, North Carolina, 55276, United States                              | lawrence.hernandez@example.com    | Lawrence    | Hernandez     | Mr    |
            | 286 | 1082 W Gray St, Mildura, Australian Capital Territory, 9140, Australia                   | beverley.howard@example.com       | Beverley    | Howard        | Mrs   |
            | 287 | 8594 Victoria Road, Clonakilty, Mayo, 50926, Ireland                                     | jessie.peters@example.com         | Jessie      | Peters        | Mr    |
            | 288 | 2399 Westmoreland Street, Athy, Cork, 83041, Ireland                                     | randall.young@example.com         | Randall     | Young         | Mr    |
            | 289 | 8420 Wheeler Ridge Dr, Orange, Illinois, 58369, United States                            | perry.williamson@example.com      | Perry       | Williamson    | Mr    |
            | 290 | 5773 Albert Road, Lincoln, Rutland, I6V 9UG, United Kingdom                              | wyatt.patterson@example.com       | Wyatt       | Patterson     | Mr    |
            | 291 | 7323 N Stelling Rd, Fremont, Pennsylvania, 66388, United States                          | amanda.reynolds@example.com       | Amanda      | Reynolds      | Ms    |
            | 292 | 2467 Poplar Dr, Duncanville, Iowa, 45474, United States                                  | letitia.mason@example.com         | Letitia     | Mason         | Mrs   |
            | 293 | 4687 School Lane, Swords, Leitrim, 85785, Ireland                                        | logan.willis@example.com          | Logan       | Willis        | Mr    |
            | 294 | 9350 York Road, Coventry, Kent, F66 9TJ, United Kingdom                                  | abbie.lewis@example.com           | Abbie       | Lewis         | Mrs   |
            | 295 | 6829 High Street, Roscommon, Monaghan, 48833, Ireland                                    | ellie.bryant@example.com          | Ellie       | Bryant        | Mrs   |
            | 296 | 7046 Mill Lane, Buncrana, Galway City, 29843, Ireland                                    | tom.davis@example.com             | Tom         | Davis         | Mr    |
            | 297 | 583 New Street, York, Lothian, GJ1 0FJ, United Kingdom                                   | lillian.hernandez@example.com     | Lillian     | Hernandez     | Miss  |
            | 298 | 8564 Poplar Dr, Gainesville, North Dakota, 93733, United States                          | vanessa.brooks@example.com        | Vanessa     | Brooks        | Mrs   |
            | 299 | 9194 9th St, Cochrane, Northwest Territories, X8D 3R6, Canada                            | dominic.harris@example.com        | Dominic     | Harris        | Mr    |
            | 300 | 366 North Street, Mallow, Tipperary, 22374, Ireland                                      | louise.jones@example.com          | Louise      | Jones         | Ms    |
            """;
}