build-image:
    @ docker build -f devops/Dockerfile -t grasshopperpi:1 .
volume:
    @ docker volume create pg_pi_grasshopper_data
deploy:
    @ docker stack deploy --with-registry-auth -c devops/stack.yml grasshopperpi
rm:
    @ docker stack rm grasshopperpi
