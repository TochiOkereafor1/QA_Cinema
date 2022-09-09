# QA Cinema Project

The project objective was:

- To create a Spring boot (Java)/JS-based full stack Web application suitable for a well-known cinema chain, QA Cinemas, with a CI/CD (Jenkins) pipeline.

### Prerequisites

- Java IDE - Eclipse/Intellij
- VS Code - front end coding in JS, HTML and CSS
- MySQL/H2/RDS on AWS - database backend (data persistence layer)
- Maven - build tool
- JUnit & Mockito - testing
- Jenkins - CI/CD pipeline
- Amazon Web Services - to host the web application and CI/CD pipeline
- Git & Github - version control & source code management
- Trello - Project management (Kanban board)

### Testing

- JUnit (Mockito), unit and integration testing was performed on the backend code, with the following test coverage figures achieved.
- Test coverage (of main/java/ folder):  83.6 %
- Test coverage (overall): 92.8 %

### Project management board

- https://trello.com/b/avq7Ch9x/cinema

### Getting Started
-Clone the repository, and import the project into your spring boot enabled IDE of choice.
-Run the project as a spring boot app.
-Connect to localhost:8081.
-In another tab, connect to localhost:8081/h2 and log in.
-Run the following scripts one at a time:

-(INSERT INTO Films(title, duration, rating) VALUES

('Castaway', 135, '18'),
('Golden Eye', 150, '18'),
('Cars', 117, 'PG'),
('Nope', 115, '15');)

-(INSERT INTO Screening (date, time, film_Id) VALUES 

('12-09-2022', '13:00', 3),
('12-09-2022', '15:30', 1),
('12-09-2022', '18:30', 2),
('12-09-2022', '21:00', 3),
('13-09-2022', '13:00', 2),
('13-09-2022', '15:30', 1),
('13-09-2022', '18:30', 2),
('13-09-2022', '21:00', 4),
('14-09-2022', '14:00', 2),
('14-09-2022', '19:30', 4),
('15-09-2022', '13:00', 3),
('15-09-2022', '15:30', 1),
('15-09-2022', '18:30', 2),
('15-09-2022', '21:00', 3),
('16-09-2022', '13:45', 2),
('16-09-2022', '19:00', 1),
('16-09-2022', '22:00', 4),
('17-09-2022', '10:00', 3),
('17-09-2022', '12:30', 1),
('17-09-2022', '15:30', 2),
('17-09-2022', '18:00', 1),
('17-09-2022', '21:00', 4),
('18-09-2022', '13:50', 3),
('18-09-2022', '13:45', 2),
('18-09-2022', '19:00', 4);)

-(Select f.film_id, f.title, s.screening_id, s.date, s.time 
from screening s
join films f on f.film_id=s.film_id order by f.film_id;)

-You should have a list of all the films and screenings organised by film.
-Return to the website and enjoy!

### Project team

- Sarah Dankwa
- Tochi Okereafor
- James Callender
- Andrew Slator
