gradle clean bootJar -x test

# Run the application

JFR_OPTIONS="-XX:StartFlightRecording=delay=5s,disk=false,dumponexit=true,duration=60s,filename=demo.jfr -XX:FlightRecorderOptions=duration=60s,filename=demo.jfr -XX:FlightRecorderOptions=stackdepth=128,maxchunksize=2M"

JVM_OPTIONS="-Xms512m -Xmx512m -XX:+UseG1GC -XX:+DisableExplicitGC -Xlog:gc*:gc.log:time -XX:MaxGCPauseMillis=200 ${JFR_OPTIONS}"

java ${JVM_OPTIONS} -jar build/libs/jfr-demo-1.0-SNAPSHOT.jar

