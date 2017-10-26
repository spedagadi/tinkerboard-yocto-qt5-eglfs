#! /bin/bash
### BEGIN INIT INFO
# Provides: dvfs rules
# Description: rules to deal with dvfs
### END INIT INFO

COMPATIBLE=$(cat /proc/device-tree/compatible)

case $1 in
start)
	if [[ $COMPATIBLE =~ "rk3288" ]]; then
		echo ondemand >/sys/devices/system/cpu/cpufreq/policy0/scaling_governor
	elif [[ $COMPATIBLE =~ "rk3036" ]]; then
		echo ondemand >/sys/devices/system/cpu/cpufreq/policy0/scaling_governor
	fi
	;;
esac

exit 0
