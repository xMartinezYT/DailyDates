$serviceName = W3SVC

# Verifica el estado del servicio IIS

$service = Get-Service -Name $serviceName

if ($service.Status -eq 'Running') {

    Write-Output El servidor IIS está en funcionamiento.

} else {

    Write-Output El servidor IIS está detenido. Intentando reiniciarlo...
  
    Start-Service -Name $serviceName
    
    Start-Sleep -Seconds 5

    $service.Refresh()

    if ($service.Status -eq 'Running') {

        Write-Output IIS se ha reiniciado con éxito.

    } else {

        Write-Output Error No se pudo reiniciar IIS.

    }

}
