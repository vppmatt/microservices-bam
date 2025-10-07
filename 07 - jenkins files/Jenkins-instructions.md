# Set up a Jenkins pipeline

## Step 1 -Log onto Jenkins

1. Visit http://your-linux-server:8080 
2. Log in with the username admin and the password that we use for the Windows VMs.

## Step 2 - configure the database password in Jenkins

We don't want to store passwords in our files so we'll safely store this in Jenkins 

1. Click on the "manage Jenkins" cog icon at the top right of the screen
2. In the "Security" section click on "Configure credentials"
3. Click on "(global)" in the domains column
4. Click on the "+ Add Credentials" button
5. Set the Kind to "Secret text"
6. Set the Scope to "Global"
7. Set the Secret to the password for your database
8. Set the id to "DBPASSWORD"


Install Snap
```
sudo wget -O /etc/yum.repos.d/snapd.repo https://bboozzoo.github.io/snapd-amazon-linux/al2023/snapd.repo
sudo dnf install snapd -y
```
