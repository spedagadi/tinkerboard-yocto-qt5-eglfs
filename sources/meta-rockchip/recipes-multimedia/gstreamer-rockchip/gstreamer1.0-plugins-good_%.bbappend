SRC_URI += " \
	file://0001-qtdemux-don-t-skip-the-stream-duration-longer-than-3.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"
