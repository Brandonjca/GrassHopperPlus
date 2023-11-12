build-image:
    @ docker build -f devops/Dockerfile -t grasshopperPI:1 .
volume:
    @ docker volume create pg_pi_grasshopper_data
deploy:
    @ docker stack deploy --with-registry-auth -c devops/stack.yml grasshopperPI
rm:
    @ docker stack rm grasshopperPI
