SRC_URI += " \
	file://0015-HACK-always-reutrn-true-when-check-format.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_remove = "vulkan"
