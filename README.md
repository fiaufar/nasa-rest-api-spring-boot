# Nasa REST API Spring Boot

I'm building this project from scratch using Java Spring boot, bassically this web
service is provided some REST APIs to get the Asteroid data from API NASA (https://api.nasa.gov/).
The APIs has been adjusted based on requirements. I'm implemented a Clean Architecture
to structure the code.

## Technology & Depedency:
- Maven v3.9.6
- Java version: 21.0.2
- Spring Boot v3.2.3
- Docker compose v2.15.1
- Lombok
- JUnit v5.10.2
- AssertJ
- Mockito
- Mapstruct v1.6.0

## How to run the project:
You can run the project using docker-compose. 
- First open the terminal and go to the project directory, and then run the command below:
<pre>
  <code>
    docker-compose up
  </code>
</pre>
- After successfully run, you can access the service to http://localhost:8080/api/v1/asteroid

# APIs
- Get Top 10 Closest Asteroid by Date Range (Sorted by miss_distance_in_kilometers ASC)
  
  Method: GET
  
  Path: /top-closest
  
  Parameters:
  <table>
    <tr>
      <th>Parameter</th>
      <th>Required</th>
      <th>Note</th>
    </tr>
    <tr>
      <td>start_date</td>
      <td>true</td>
      <td>ex=2024-01-27</td>
    </tr>
    <tr>
      <td>end_date</td>
      <td>true</td>
      <td>ex=2024-01-31 (maximum 7 days from start_date)</td>
    </tr>
  </table>
  Example: http://localhost:8080/api/v1/asteroid/top-closest?start_date=2015-01-21&end_date=15-01-22
  
  Response: 
  <pre>
    <code>
    [
      {
        "id": "2357439",
        "name": "357439 (2004 BL86)",
        "absolute_magnitude_h": 19.29,
        "close_approach_date_full": "2015-Jan-26 16:49",
        "miss_distance_in_astronomical": 0.0080208404,
        "miss_distance_in_lunar": 3.1201069156,
        "miss_distance_in_kilometers": 1199900.639449948,
        "estimated_diameter_min_in_kilometer": 0.3685996993,
        "estimated_diameter_max_in_kilometer": 0.8242139842,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3838039",
        "name": "(2019 BU3)",
        "absolute_magnitude_h": 29.1,
        "close_approach_date_full": "2015-Jan-23 16:33",
        "miss_distance_in_astronomical": 0.011115349,
        "miss_distance_in_lunar": 4.323870761,
        "miss_distance_in_kilometers": 1662832.53470663,
        "estimated_diameter_min_in_kilometer": 0.0040230458,
        "estimated_diameter_max_in_kilometer": 0.0089958039,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3703788",
        "name": "(2015 AK45)",
        "absolute_magnitude_h": 26.4,
        "close_approach_date_full": "2015-Jan-26 21:12",
        "miss_distance_in_astronomical": 0.0121618073,
        "miss_distance_in_lunar": 4.7309430397,
        "miss_distance_in_kilometers": 1819380.467430451,
        "estimated_diameter_min_in_kilometer": 0.0139493823,
        "estimated_diameter_max_in_kilometer": 0.0311917671,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3704157",
        "name": "(2015 BK4)",
        "absolute_magnitude_h": 24.9,
        "close_approach_date_full": "2015-Jan-25 01:25",
        "miss_distance_in_astronomical": 0.0136866878,
        "miss_distance_in_lunar": 5.3241215542,
        "miss_distance_in_kilometers": 2047499.342234986,
        "estimated_diameter_min_in_kilometer": 0.0278326768,
        "estimated_diameter_max_in_kilometer": 0.0622357573,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "54244780",
        "name": "(2022 CC1)",
        "absolute_magnitude_h": 27.12,
        "close_approach_date_full": "2015-Jan-24 08:30",
        "miss_distance_in_astronomical": 0.0145295532,
        "miss_distance_in_lunar": 5.6519961948,
        "miss_distance_in_kilometers": 2173590.210771684,
        "estimated_diameter_min_in_kilometer": 0.010012787,
        "estimated_diameter_max_in_kilometer": 0.0223892723,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3703792",
        "name": "(2015 BF)",
        "absolute_magnitude_h": 26.6,
        "close_approach_date_full": "2015-Jan-25 10:28",
        "miss_distance_in_astronomical": 0.0239223706,
        "miss_distance_in_lunar": 9.3058021634,
        "miss_distance_in_kilometers": 3578735.687110622,
        "estimated_diameter_min_in_kilometer": 0.0127219879,
        "estimated_diameter_max_in_kilometer": 0.0284472297,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3837987",
        "name": "(2019 BO2)",
        "absolute_magnitude_h": 26.1,
        "close_approach_date_full": "2015-Jan-25 21:30",
        "miss_distance_in_astronomical": 0.027680616,
        "miss_distance_in_lunar": 10.767759624,
        "miss_distance_in_kilometers": 4140961.19388792,
        "estimated_diameter_min_in_kilometer": 0.0160160338,
        "estimated_diameter_max_in_kilometer": 0.0358129403,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3709248",
        "name": "(2015 BW512)",
        "absolute_magnitude_h": 25.2,
        "close_approach_date_full": "2015-Jan-24 05:19",
        "miss_distance_in_astronomical": 0.0290697194,
        "miss_distance_in_lunar": 11.3081208466,
        "miss_distance_in_kilometers": 4348768.103737678,
        "estimated_diameter_min_in_kilometer": 0.0242412481,
        "estimated_diameter_max_in_kilometer": 0.0542050786,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "3703548",
        "name": "(2015 AP44)",
        "absolute_magnitude_h": 26.2,
        "close_approach_date_full": "2015-Jan-24 12:27",
        "miss_distance_in_astronomical": 0.0305241819,
        "miss_distance_in_lunar": 11.8739067591,
        "miss_distance_in_kilometers": 4566352.595732553,
        "estimated_diameter_min_in_kilometer": 0.0152951935,
        "estimated_diameter_max_in_kilometer": 0.0342010925,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      },
      {
        "id": "54107791",
        "name": "(2021 BJ3)",
        "absolute_magnitude_h": 25.1,
        "close_approach_date_full": "2015-Jan-27 14:25",
        "miss_distance_in_astronomical": 0.0353913864,
        "miss_distance_in_lunar": 13.7672493096,
        "miss_distance_in_kilometers": 5294476.021786968,
        "estimated_diameter_min_in_kilometer": 0.0253837029,
        "estimated_diameter_max_in_kilometer": 0.0567596853,
        "potentially_hazardous_asteroid": false,
        "sentry_object": false
      }
    ]
    </code>
  </pre>

- Get Total number of Asteroids that are X kilometers or more away
  
  Method: GET
  
  Path: /total-closest
  
  Parameters:
  <table>
    <tr>
      <th>Parameter</th>
      <th>Required</th>
      <th>Note</th>
    </tr>
    <tr>
      <td>distance</td>
      <td>true</td>
      <td>ex=450000</td>
    </tr>
  </table>
  Example: http://localhost:8080/api/v1/asteroid/total-closest?distance=1000000
  
  Response: 
  <pre>
    <code>
      {
        "total": 39
      }
    </code>
  </pre>
