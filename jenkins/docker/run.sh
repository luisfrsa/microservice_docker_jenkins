echo "Starting Gitlab";
docker-compose -f docker-compose-gitlab.yml up --build -d;
echo "Starting Jenkins";
docker-compose -f docker-compose-jenkins.yml up --build -d;
echo "Starting SonarQube";
docker-compose -f docker-compose-sonar.yml up --build -d;