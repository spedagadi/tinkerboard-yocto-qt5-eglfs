SUMMARY = "Open Source multimedia player"
DESCRIPTION = "mpv is a fork of mplayer2 and MPlayer. It shares some features with the former projects while introducing many more."
SECTION = "multimedia"
HOMEPAGE = "http://www.mpv.io/"
DEPENDS = "zlib ffmpeg jpeg libv4l libdrm"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91f1cb870c1cc2d31351a4d2595441cb"

SRCREV = "474a7c26f226277cfd173034bc22b35970f0f4ef"
SRC_URI = "git://github.com/mpv-player/mpv.git;branch=master \
           http://www.freehackers.org/~tnagy/release/waf-1.8.12;name=waf; \
           file://Add-DRM_PRIME-Format-Handling-and-Display-for-RockCh.patch \
"
S = "${WORKDIR}/git"

SRC_URI[waf.md5sum] = "cef4ee82206b1843db082d0b0506bf71"
SRC_URI[waf.sha256sum] = "01bf2beab2106d1558800c8709bc2c8e496d3da4a2ca343fe091f22fca60c98b"

inherit waf pkgconfig pythonnative distro_features_check

# Note: both lua and libass are required to get on-screen-display (controls)
PACKAGECONFIG ??= "libass"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,lua luajit"
PACKAGECONFIG[libass] = "--enable-libass,--disable-libass,libass"
PACKAGECONFIG[libarchive] = "--enable-libarchive,--disable-libarchive,libarchive"
PACKAGECONFIG[jack] = "--enable-jack, --disable-jack, jack"

DEPENDS = "virtual/egl rockchip-mpp ffmpeg"

SIMPLE_TARGET_SYS = "${@'${TARGET_SYS}'.replace('${TARGET_VENDOR}', '')}"
EXTRA_OECONF = " \
    --prefix=${prefix} \
    --target=${SIMPLE_TARGET_SYS} \
    --confdir=${sysconfdir} \
    --datadir=${datadir} \
    --disable-manpage-build \
    --disable-libsmbclient \
    --disable-encoding \
    --disable-libbluray \
    --disable-dvdread \
    --disable-dvdnav \
    --disable-cdda \
    --disable-uchardet \
    --disable-rubberband \
    --disable-lcms2 \
    --disable-vapoursynth \
    --disable-vapoursynth-lazy \
    --disable-cuda-hwaccel \
    ${PACKAGECONFIG_CONFARGS} \
"

do_configure_prepend () {
    ln -sf ${WORKDIR}/waf-1.8.12 ${S}/waf
    chmod +x ${S}/waf
}

FILES_${PN} += "${datadir}/icons"