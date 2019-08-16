PROJECT=dev-tech-team
FS=kf-demo-data
ZONE=europe-west1-b    

gcloud beta filestore instances create ${FS}     --project=${PROJECT}     --location=${ZONE}     --tier=STANDARD     --file-share=name="volumes",capacity=1TB     --network=name="default",reserved-ip-range="10.0.0.0/29"

FSADDR=$(gcloud beta filestore instances describe ${FS} --project=${PROJECT} --location=${ZONE} --format="value(networks.ipAddresses[0])")

helm install --namespace kubeflow stable/nfs-client-provisioner --name nfs-cp --set nfs.server=${FSADDR} --set nfs.path=/volumes
kubectl rollout status  deploy/nfs-cp-nfs-client-provisioner -n kubeflow
