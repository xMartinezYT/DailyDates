# Obtiene la ubicación actual del directorio en el que se está ejecutando el script

$directorioActual = Get-Location


# Crea una ruta completa para un nuevo directorio llamado "copia_seguridad" dentro del directorio actual

$directorioCopia = Join-Path -Path $directorioActual -ChildPath "copia_seguridad"


# Comprueba si el directorio de copia de seguridad no existe

if (-Not (Test-Path -Path $directorioCopia)) {
    # Si no existe, crea el nuevo directorio "copia_seguridad"
    New-Item -ItemType Directory -Path $directorioCopia
}


# Obtiene todos los archivos en el directorio actual y para cada archivo copia cada archivo al directorio de copia de seguridad

Get-ChildItem -Path $directorioActual -File | ForEach-Object {

    Copy-Item -Path $_.FullName -Destination $directorioCopia

}