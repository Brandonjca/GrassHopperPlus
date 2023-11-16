build-image:
    @ docker build -f Devops/Dockerfile -t grasshopperpi:1 .
volume:
    @ docker volume create pg_pi_grasshopper_data
deploy:
    @ docker stack deploy --with-registry-auth -c Devops/stack.yml grasshopperpi
rm:
    @ docker stack rm grasshopperpi