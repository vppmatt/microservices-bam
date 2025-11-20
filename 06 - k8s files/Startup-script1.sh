git clone https://github.com/albuild/snap.git
cd snap
bin/build
bin/cp
cd ~

sleep 10

sudo snap install microk8s --classic --channel=1.33

sudo usermod -a -G microk8s $USER
mkdir -p ~/.kube
chmod 0700 ~/.kube
su - $USER

