SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image
inherit extrausers
#set the rootfs to 200 MiB by default you can set it as you want if you have more application
IMAGE_OVERHEAD_FACTOR ?= "1.0"
#with using the soft assignment (?=) we allow somebody to change this variable in the root dir ( so in conf/local.conf). 
IMAGE_ROOTFS_SIZE ?= "204800"
#
# change users passwrd. (change root password here)

# with using the hard assignement (=) we assume that this variable we take this value and nobody can change it even if in the build directory (conf/local.conf)

EXTRA_USERS_PARAMS = "\
	usermod -P '98245134' root \
	"

DESCRIPTION = "A small image with a SSH server for remote access"

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL +="wpa-supplicant dhcp-client linux-firmware"
