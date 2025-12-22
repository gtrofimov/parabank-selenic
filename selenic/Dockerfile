FROM parasoft/selenic:latest AS selenic

FROM jelastic/maven:3.9.12-temurinjdk-21.0.9-almalinux-9

USER root:root

# Install Selenic
COPY --from=selenic /opt/parasoft/selenic selenic

# Install Chrome and dependencies
RUN yum update -y && \
    yum install -y chromium chromium-headless && \
    yum install -y mesa-libGL libX11 libXrandr libXinerama libXcursor libXi libXxf86vm && \
    yum clean all

USER root:root